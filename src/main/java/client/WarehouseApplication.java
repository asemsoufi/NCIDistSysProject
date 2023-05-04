package client;

import grpc.employeeService.*;
import grpc.orderService.*;
import grpc.stockService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import warehouse.Order;
import warehouse.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class WarehouseApplication {

    // employee stubs
    private static EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeServiceBlockingStub;
    private static EmployeeServiceGrpc.EmployeeServiceStub employeeServiceAsyncStub;
    // order stubs
    private static OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;
    private static OrderServiceGrpc.OrderServiceStub orderServiceAsyncStub;
    // stock stubs
    private static StockServiceGrpc.StockServiceBlockingStub stockServiceBlockingStub;
    private static StockServiceGrpc.StockServiceStub stockServiceAsyncStub;

    private static ArrayList<Order.OrderItem> orderItems = new ArrayList<>();
    private static int num;


    private JFrame frame;
    private JTextField employeeNumber;
    private JLabel lblAddEmployee;
    private JLabel lblAddProduct;
    private JButton btnPlaceOrder;
    private static JButton btnNewOrder;
    private JLabel lblStockAvailability;
    private JTextField stockNumber;
    private JTextField orderNumber;


    private static JTextArea employeeTextArea;
    private static JTextArea orderTextArea;
    private static JTextArea placeOrderTextArea;
    private static JTextArea stockTextArea;

    private JButton btnCancelOrder;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WarehouseApplication window = new WarehouseApplication();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public WarehouseApplication() {


        String host = "localhost";
        // employee channel
        ManagedChannel employeeChannel = ManagedChannelBuilder
                .forAddress(host, 50053)
                .usePlaintext()
                .build();
        //employee stubs -- generate from proto
        employeeServiceBlockingStub = EmployeeServiceGrpc.newBlockingStub(employeeChannel);
        employeeServiceAsyncStub = EmployeeServiceGrpc.newStub(employeeChannel);

        // order channel
        ManagedChannel orderChannel = ManagedChannelBuilder
                .forAddress(host, 50051)
                .usePlaintext()
                .build();
        //order stubs -- generate from proto
        orderServiceBlockingStub = OrderServiceGrpc.newBlockingStub(orderChannel);
        orderServiceAsyncStub = OrderServiceGrpc.newStub(orderChannel);

        // stock channel
        ManagedChannel stockChannel = ManagedChannelBuilder
                .forAddress(host, 50052)
                .usePlaintext()
                .build();
        //stock stubs -- generate from proto
        stockServiceBlockingStub = StockServiceGrpc.newBlockingStub(stockChannel);
        stockServiceAsyncStub = StockServiceGrpc.newStub(stockChannel);

        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setTitle("Warehouse Services Controller");
        ImageIcon img = new ImageIcon(".//Files//logo.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(100, 100, 800, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);
        // show frame in the center of the display window
        frame.setLocationRelativeTo(null);
        // Main tabbed pane
        JTabbedPane mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(mainTabbedPane);
        // dont allow resize of tabbed pane
        frame.setResizable(false);


        JTabbedPane employeeTab = new JTabbedPane(JTabbedPane.TOP);
        mainTabbedPane.addTab("Employees", null, employeeTab, null);

        // Employee tabs
        JPanel panel_service_searchEmployee = new JPanel();
        JPanel panel_service_addEmployee = new JPanel();
        employeeTab.addTab("Search Employees", null, panel_service_searchEmployee, null);
        employeeTab.addTab("Add Employee", null, panel_service_addEmployee, null);
        panel_service_searchEmployee.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_service_addEmployee.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Employee Number");
        panel_service_searchEmployee.add(lblNewLabel_1);

        employeeNumber = new JTextField();
        panel_service_searchEmployee.add(employeeNumber);
        employeeNumber.setColumns(10);



        JButton btnGetEmployee = new JButton("Find Employee");
        btnGetEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeTextArea.setText("");
                int num;

                try {
                    num = Integer.parseInt(employeeNumber.getText());
                } catch (NumberFormatException ex) {
                    employeeTextArea.append("Enter a valid Employee number!" + "\n");
                    return;
                }

                GetEmployeeRequest req = GetEmployeeRequest.newBuilder().setEmployeeNumber(num).build();
                try {
                    GetEmployeeResponse response = employeeServiceBlockingStub.getEmployee(req);
                    employeeTextArea.append(response.getEmployeeDetails() + "\n");
                }
                catch (Exception ex) {
                    employeeTextArea.append("Server not running!\n");
                }

            }
        });

        JButton btnGetAllEmployees = new JButton("List All Employees");
        btnGetAllEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeTextArea.setText("");
                employeeNumber.setText("");

                GetAllEmployeesRequest request = GetAllEmployeesRequest.newBuilder().build();
                StreamObserver<GetEmployeeResponse> responseStreamObserver = new StreamObserver<GetEmployeeResponse>() {
                    int count = 0;
                    @Override
                    public void onNext(GetEmployeeResponse response) {
                        employeeTextArea.append(response.getEmployeeDetails() + "\n");
                        count += 1;
                        waitFor(100);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {
                        employeeTextArea.append("Completed listing all " + count + " employees.\n");
                    }

                };

                employeeServiceAsyncStub.getAllEmployees(request, responseStreamObserver);
            }
        });

        JButton btnClearResults = new JButton("Clear Results");
        btnClearResults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeTextArea.setText("");
                employeeNumber.setText("");
            }
        });

        // add an employee number, employee name, position, salary and a submit button
        JLabel lblNewLabel_2 = new JLabel("Employee Number");
        panel_service_addEmployee.add(lblNewLabel_2);
        JTextField numberField = new JTextField();
        numberField.setColumns(10);
        panel_service_addEmployee.add(numberField);
        JLabel lblNewLabel_3 = new JLabel("Employee Name");
        panel_service_addEmployee.add(lblNewLabel_3);
        JTextField nameField = new JTextField();
        nameField.setColumns(10);
        panel_service_addEmployee.add(nameField);
        JLabel lblNewLabel_4 = new JLabel("Position");
        panel_service_addEmployee.add(lblNewLabel_4);
        JTextField positionField = new JTextField();
        positionField.setColumns(10);
        panel_service_addEmployee.add(positionField);
        JLabel lblNewLabel_5 = new JLabel("Salary");
        panel_service_addEmployee.add(lblNewLabel_5);
        JTextField salaryField = new JTextField();
        salaryField.setColumns(10);
        panel_service_addEmployee.add(salaryField);

        // add a button to submit request to add new employee
        JButton btnAddEmployee = new JButton("Submit");
        panel_service_addEmployee.add(btnAddEmployee);
        btnAddEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddEmployeeResponse response = null;
                try {
                    int empNumber = Integer.parseInt(numberField.getText());
                    String name = nameField.getText();
                    String position = positionField.getText();
                    int salary = Integer.parseInt(salaryField.getText());

                    AddEmployeeRequest req = AddEmployeeRequest.newBuilder().setEmployeeNumber(empNumber).setEmployeeName(name).setPosition(position).setSalary(salary).build();
                    response = employeeServiceBlockingStub.addEmployee(req);
                    if (response.getSuccess()) {
                        lblAddEmployee.setText(response.getMessage());
                        lblAddEmployee.setForeground(Color.darkGray);
                    } else {
                        lblAddEmployee.setText(response.getMessage());
                        lblAddEmployee.setForeground(Color.RED);
                    }
                } catch (Exception ex) {
                    lblAddEmployee.setText("Error!");
                    lblAddEmployee.setForeground(Color.RED);
                }
            }
        });

        // add a label to display the response
        lblAddEmployee = new JLabel("");
        panel_service_addEmployee.add(lblAddEmployee);

        panel_service_searchEmployee.add(btnGetEmployee);
        panel_service_searchEmployee.add(btnGetAllEmployees);
        panel_service_searchEmployee.add(btnClearResults);


        employeeTextArea = new JTextArea(23, 65);
        employeeTextArea.setLineWrap(true);
        employeeTextArea.setWrapStyleWord(true);
        employeeTextArea.setEditable(false);
        employeeTextArea.setFont(employeeTextArea.getFont().deriveFont(12f));


        JScrollPane scrollPane = new JScrollPane(employeeTextArea);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_searchEmployee.add(scrollPane);

        JTabbedPane stockTab = new JTabbedPane(JTabbedPane.TOP);
        mainTabbedPane.addTab("Stock", null, stockTab, null);

        // Employee tabs
        JPanel panel_service_searchStock = new JPanel();
        JPanel panel_service_addProduct = new JPanel();
        stockTab.addTab("Search Stock", null, panel_service_searchStock, null);
        stockTab.addTab("Add Product", null, panel_service_addProduct, null);
        panel_service_searchStock.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_service_addProduct.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_searchStock = new JLabel("Stock Number");
        panel_service_searchStock.add(lblNewLabel_searchStock);

        stockNumber = new JTextField();
        panel_service_searchStock.add(stockNumber);
        stockNumber.setColumns(10);



        JButton btnGetProduct = new JButton("Find Product");
        btnGetProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stockTextArea.setText("");
                int num = -1;
                if (stockNumber.getText().length() > 0 ) {
                    try {
                        num = Integer.parseInt(stockNumber.getText());
                    } catch (Exception ex) {
                        stockTextArea.setText("Invalid stock number!");
                        stockNumber.setText("");
                        return;
                    }
                }

                ProductRequest request = ProductRequest.newBuilder().setStockNumber(num).build();
                StreamObserver<ProductResponse> responseStreamObserver = new StreamObserver<ProductResponse>() {
                    @Override
                    public void onNext(ProductResponse response) {
                        if (response.getStockNumber() != -1) {
                            stockTextArea.append("Product{no." + response.getStockNumber() + ", " + response.getDescription() +
                                    ", price:" + response.getPrice() + ", qty:" + response.getQty() + "}\n");
                        } else {
                            stockTextArea.append(response.getDescription()+ "\n");
                        }
                        waitFor(100);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {}

                };

                stockServiceAsyncStub.getProduct(request, responseStreamObserver);

            }
        });

        JButton btnClearStockResults = new JButton("Clear Results");
        btnClearStockResults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stockTextArea.setText("");
                stockNumber.setText("");
            }
        });

        // add an employee number, employee name, position, salary and a submit button
        JLabel lblProductNumber = new JLabel("Product Number");
        panel_service_addProduct.add(lblProductNumber);
        JTextField productNumberField = new JTextField();
        productNumberField.setColumns(6);
        panel_service_addProduct.add(productNumberField);

        JLabel lblDescription = new JLabel("Description");
        panel_service_addProduct.add(lblDescription);
        JTextField descriptionField = new JTextField();
        descriptionField.setColumns(26);
        panel_service_addProduct.add(descriptionField);

        JLabel lblPrice = new JLabel("Price");
        panel_service_addProduct.add(lblPrice);
        JTextField priceField = new JTextField();
        priceField.setColumns(6);
        panel_service_addProduct.add(priceField);

        JLabel lblQty = new JLabel("Quantity");
        panel_service_addProduct.add(lblQty);
        JTextField qtyField = new JTextField();
        qtyField.setColumns(4);
        panel_service_addProduct.add(qtyField);

        // add a button to submit request to add new employee
        JButton btnAddProduct = new JButton("Submit");
        panel_service_addProduct.add(btnAddProduct);
        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddProductResponse response = null;
                try {
                    int prodNumber = Integer.parseInt(productNumberField.getText());
                    String descr = descriptionField.getText();
                    float price = Float.parseFloat(priceField.getText());
                    int qty = Integer.parseInt(qtyField.getText());

                    AddProductRequest req = AddProductRequest.newBuilder().setStockNumber(prodNumber).setDescription(descr).setPrice(price).setQty(qty).build();
                    response = stockServiceBlockingStub.addProduct(req);
                    if (response.getSuccess()) {
                        lblAddProduct.setText(response.getMessage());
                        lblAddProduct.setForeground(Color.darkGray);
                    } else {
                        lblAddProduct.setText(response.getMessage());
                        lblAddProduct.setForeground(Color.RED);
                    }
                } catch (Exception ex) {
                    lblAddProduct.setText("Error!");
                    lblAddProduct.setForeground(Color.RED);
                }
            }
        });

        // add a label to display the response
        lblAddProduct = new JLabel("");
        panel_service_addProduct.add(lblAddProduct);

        panel_service_searchStock.add(btnGetProduct);
        panel_service_searchStock.add(btnClearStockResults);


        stockTextArea = new JTextArea(20, 65);
        stockTextArea.setLineWrap(true);
        stockTextArea.setWrapStyleWord(true);
        stockTextArea.setEditable(false);
        stockTextArea.setFont(stockTextArea.getFont().deriveFont(14f));


        JScrollPane scrollPaneStock = new JScrollPane(stockTextArea);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_searchStock.add(scrollPaneStock);

        /***********************************************************************************/

        JTabbedPane orderTab = new JTabbedPane(JTabbedPane.TOP);
        mainTabbedPane.addTab("Orders", null, orderTab, null);

        // Employee tabs
        JPanel panel_service_searchOrders = new JPanel();
        JPanel panel_service_addOrder = new JPanel();
        orderTab.addTab("Search Orders", null, panel_service_searchOrders, null);
        orderTab.addTab("Place Order", null, panel_service_addOrder, null);
        panel_service_searchOrders.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_service_addOrder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_searchOrders = new JLabel("Order Number");
        panel_service_searchOrders.add(lblNewLabel_searchOrders);

        orderNumber = new JTextField();
        panel_service_searchOrders.add(orderNumber);
        orderNumber.setColumns(10);



        JButton btnGetOrder = new JButton("List Orders");
        num = -1;
        btnGetOrder.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                orderTextArea.setText("");
                orderTextArea.setFont(orderTextArea.getFont().deriveFont(14f));


                if (orderNumber.getText().length() > 0 ) {
                    try {
                        num = Integer.parseInt(orderNumber.getText());
                        btnCancelOrder.setEnabled(true);
                    } catch (Exception ex) {
                        orderTextArea.setText("Invalid order number!");
                        orderNumber.setText("");
                        return;
                    }
                }

                GetOrderRequest request = GetOrderRequest.newBuilder().setOrderNumber(num).build();
                StreamObserver<GetOrderResponse> responseStreamObserver = new StreamObserver<GetOrderResponse>() {
                    @Override
                    public void onNext(GetOrderResponse response) {

                        orderTextArea.append(response.getOrderDetails()+ "\n");
                        orderTextArea.append("---------------------------------------------------------------------" +
                                "-------------\n");
                        if (response.getOrderDetails().equals("Order not found!")){
                            btnCancelOrder.setEnabled(false);
                        }

                        //waitFor(100);
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                    @Override
                    public void onCompleted() {
                        // add a summary line with total sales value
                        if (num == -1) {
                            TotalSalesRequest req = TotalSalesRequest.newBuilder().build();
                            TotalSalesResponse response = orderServiceBlockingStub.getTotalSales(req);
                            orderTextArea.append("Total Sales for all orders: €" + String.format("%,.2f",response.getSalesTotal()) + "\n");
                        } else {
                            num = -1;
                        }
                    }
                };
                orderServiceAsyncStub.getOrderDetails(request, responseStreamObserver);
            }
        });

        btnCancelOrder = new JButton("Cancel Order");
        btnCancelOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                CancelOrderRequest req = CancelOrderRequest.newBuilder().setOrderNumber(Integer.parseInt(orderNumber.getText())).build();

                CancelOrderResponse response = orderServiceBlockingStub.cancelOrder(req);
                if (response.getSuccess()){
                    orderTextArea.setFont(orderTextArea.getFont().deriveFont(14f));
                    orderTextArea.append("* Order Cancelled *\n");
                    btnCancelOrder.setEnabled(false);
                    orderNumber.setText("");
                } else {
                    orderTextArea.setFont(orderTextArea.getFont().deriveFont(14f));
                    orderTextArea.append("Error cancelling order!\n");
                    orderNumber.setText("");
                }
                btnCancelOrder.setEnabled(false);
                num = -1;
            }
        });

        JButton btnGetTotalSales = new JButton("Show Total Sales");
        btnGetTotalSales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderTextArea.setText("");

                TotalSalesRequest req = TotalSalesRequest.newBuilder().build();

                TotalSalesResponse response = orderServiceBlockingStub.getTotalSales(req);
                orderTextArea.append("Total Sales for all orders: €" + String.format("%,.2f",response.getSalesTotal()) + "\n");
                orderTextArea.setFont(orderTextArea.getFont().deriveFont(14f));
            }
        });

        JButton btnClearOrderResults = new JButton("Clear Results");
        btnClearOrderResults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                orderTextArea.setText("");
                orderNumber.setText("");
                btnCancelOrder.setEnabled(false);
                num = -1;
            }
        });

        // add a product number, employee name, position, salary and a submit button
        lblStockAvailability = new JLabel("");
        panel_service_searchOrders.add(lblStockAvailability);
        JLabel lblOrderNumber = new JLabel("Product Number");
        panel_service_addOrder.add(lblOrderNumber);
        //create a new combobox and get data from products ArrayList
        JTextField productToOrder = new JTextField();
        productToOrder.setColumns(10);
        panel_service_addOrder.add(productToOrder);

        JLabel lblProductQty = new JLabel("Quantity");
        panel_service_addOrder.add(lblProductQty);
        JTextField productQtyField = new JTextField();
        productQtyField.setColumns(4);
        panel_service_addOrder.add(productQtyField);

        // add a button to submit request to add new employee
        JButton btnAddToOrder = new JButton("Add/Remove");
        panel_service_addOrder.add(btnAddToOrder);
        btnAddToOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrderTextArea.setText("");
                placeOrderTextArea.setFont(placeOrderTextArea.getFont().deriveFont(14f));
                lblStockAvailability.setText("");
                int productNum;
                int qtyToOrder;
                try {
                    productNum = Integer.parseInt(productToOrder.getText());
                    qtyToOrder = Integer.parseInt(productQtyField.getText());
                } catch (Exception ex) {
                    placeOrderTextArea.setText("Invalid number format!");
                    productToOrder.setText("");
                    productQtyField.setText("");
                    return;
                }

                // check if product is in stock
                ProductRequest request = ProductRequest.newBuilder().setStockNumber(productNum).build();
                StreamObserver<ProductResponse> responseStreamObserver = new StreamObserver<ProductResponse>() {
                    @Override
                    public void onNext(ProductResponse response) {
                        if (response.getQty() >= qtyToOrder) {
                            // create a product object and add it to Order Items ArrayList
                            Product product = new Product(response.getStockNumber(), response.getDescription(), response.getPrice(), response.getQty());
                            // check if product is already in the shopping cart
                            // if already in shopping cart then change quantity or remove product as needed
                            for (Order.OrderItem oi : orderItems) {
                                if (oi.product.getStockNumber() == product.getStockNumber()) {
                                    //System.out.println("item already in shopping cart");
                                    oi.quantity += qtyToOrder;
                                    //System.out.println("New quantity " + oi.quantity);
                                    if (oi.quantity <= 0) {
                                        orderItems.remove(oi);
                                    }
                                    return;
                                }
                            }
                            //System.out.println("creating new order item");
                            Order.OrderItem item = new Order.OrderItem(product, qtyToOrder);
                            //System.out.println("adding it to list");
                            orderItems.add(item);
                            btnPlaceOrder.setEnabled(true);

                        } else if (response.getQty() > 0) {
                            //lblStockAvailability.setText("Only " + response.getQty() + " left!");
                            //lblStockAvailability.setForeground(Color.RED);
                            placeOrderTextArea.append("Only " + response.getQty() + " left!\n");
                        } else {
                            //lblStockAvailability.setText("Out of stock!");
                            //lblStockAvailability.setForeground(Color.RED);
                            placeOrderTextArea.append("Not in stock!\n");
                        }
                        waitFor(100);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {
                        for (Order.OrderItem oi : orderItems) {
                            placeOrderTextArea.append("Product no." + oi.product.getStockNumber() + ", " + oi.product.getDescription() +
                                    ", price:" + oi.product.getPrice() + ", qty:" + oi.quantity + ", Sub-Total: €"+
                                    String.format("%,.2f",oi.product.getPrice() * oi.quantity) + "\n");
                        }
                    }

                };

                stockServiceAsyncStub.getProduct(request, responseStreamObserver);
            }

        });

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setEnabled(false);
        panel_service_addOrder.add(btnPlaceOrder);

        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // clean-up
                btnPlaceOrder.setEnabled(false);
                btnAddToOrder.setEnabled(false);
                productQtyField.setText("");
                productQtyField.setEnabled(false);
                productToOrder.setText("");
                productToOrder.setEnabled(false);
                // place order
                updateStock(placeOrderTextArea);
            }

        });

        btnNewOrder = new JButton("New Order");
        btnNewOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeOrderTextArea.setText("");
                productQtyField.setEnabled(true);
                productToOrder.setEnabled(true);
                btnAddToOrder.setEnabled(true);
                productQtyField.setText("");
                productToOrder.setText("");
                // delete all entries in orderItems ArrayList
                orderItems.clear();
            }
        });
        btnNewOrder.setEnabled(false);

        // add a label to display the response
        JLabel lblPlaceOrder = new JLabel("");
        panel_service_addOrder.add(lblPlaceOrder);

        panel_service_searchOrders.add(btnGetOrder);
        panel_service_searchOrders.add(btnCancelOrder);
        // initially deactivate btnCancelOrder
        btnCancelOrder.setEnabled(false);
        panel_service_searchOrders.add(btnGetTotalSales);
        panel_service_searchOrders.add(btnClearOrderResults);


        orderTextArea = new JTextArea(23, 65);
        orderTextArea.setLineWrap(true);
        orderTextArea.setWrapStyleWord(true);
        orderTextArea.setEditable(false);


        JScrollPane scrollPaneOrder = new JScrollPane(orderTextArea);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_searchOrders.add(scrollPaneOrder);


        placeOrderTextArea = new JTextArea(23, 65);
        placeOrderTextArea.setLineWrap(true);
        placeOrderTextArea.setWrapStyleWord(true);
        placeOrderTextArea.setEditable(false);

        panel_service_addOrder.add(btnNewOrder);


        JScrollPane scrollPanePlaceOrder = new JScrollPane(placeOrderTextArea);
        //textResponse.setSize(new Dimension(15, 30));
        panel_service_addOrder.add(scrollPanePlaceOrder);
        //panel_service_addOrder.add(lblStockAvailability);
        //panel_service_addOrder.add(btnNewOrder);
    }


    public static void updateStock(JTextArea textArea) {
        StreamObserver<UpdateQtyResponse> responseObserver =  new StreamObserver<UpdateQtyResponse>() {
            public void onNext(UpdateQtyResponse value) {
                waitFor(2000);
                textArea.append(value.getMessage() + "\n");
                // some slow motion
                waitFor(3000);
            }
            public void onCompleted() {
                textArea.append("\nAll relevant stock levels updated successfully!\n");
                waitFor(3000);

                textArea.append("\nNow placing your order");
                for (int i = 0; i < 20; i++){
                    textArea.append(".");
                    waitFor(200);
                }
                textArea.append("\n\n");

                // print new order details
                placeOrder(placeOrderTextArea);
                btnNewOrder.setEnabled(true);

            }
            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }
        };

        StreamObserver<UpdateQtyRequest> requestObserver =  stockServiceAsyncStub.updateQty(responseObserver);

        textArea.append("\nRequesting stock update");
        for (int i = 0; i < 10; i++){
            textArea.append(".");
            waitFor(200);
        }
        textArea.append("\n\n");

        //waitFor(1000);

        try {
            for (Order.OrderItem oi : orderItems) {
                requestObserver.onNext(UpdateQtyRequest.newBuilder().setStockNumber(oi.product.getStockNumber()).setQty(oi.quantity).build());
            }

            requestObserver.onCompleted();
        }
        catch(RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static void waitFor(int ms) {
        try {
            //wait for a ms milliseconds
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void placeOrder(JTextArea textArea) {
        StreamObserver<GetOrderResponse> responseObserver =  new StreamObserver<GetOrderResponse>() {
            public void onNext(GetOrderResponse value) {
                textArea.append(value.getOrderDetails() + "\n");
            }
            public void onCompleted() {}
            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }
        };

        StreamObserver<PlaceOrderRequest> requestObserver =  orderServiceAsyncStub.placeOrder(responseObserver);
        try {
            for (Order.OrderItem oi : orderItems) {
                requestObserver.onNext(PlaceOrderRequest.newBuilder().setStockNumber(oi.product.getStockNumber()).
                        setProdDescription(oi.product.getDescription()).setProdPrice(oi.product.getPrice()).
                        setProdQty(oi.product.quantity).setOrderedQty(oi.quantity).build());
            }

            requestObserver.onCompleted();

        }
        catch(RuntimeException e) {
            e.printStackTrace();
        }
    }

}
