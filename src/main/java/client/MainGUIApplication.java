package client;

import grpc.employeeService.*;
import grpc.orderService.OrderServiceGrpc;
import grpc.stockService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainGUIApplication {

    // employee stubs
    private static EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeServiceBlockingStub;
    private static EmployeeServiceGrpc.EmployeeServiceStub employeeServiceAsyncStub;
    // order stubs
    private static OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;
    private static OrderServiceGrpc.OrderServiceStub orderServiceAsyncStub;
    // stock stubs
    private static StockServiceGrpc.StockServiceBlockingStub stockServiceBlockingStub;
    private static StockServiceGrpc.StockServiceStub stockServiceAsyncStub;



    private ServiceInfo employeeServiceInfo;



    private JFrame frame;
    private JTabbedPane mainTabbedPane;
    private JTabbedPane employeeTab;
    private JTabbedPane orderTab;
    private JTabbedPane stockTab;
    private JTextField employeeNumber;
    private JLabel lblAddEmployee;
    private JLabel lblAddProduct;
    private JTextField stockNumber;


    public static JTextArea employeeTextArea;
    public static JTextArea orderTextArea;
    public static JTextArea stockTextArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainGUIApplication window = new MainGUIApplication();
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
    public MainGUIApplication() {

        /*String employee_service_type = "_employee._tcp.local.";
        discoverEmployeeService(employee_service_type);

        String host = employeeServiceInfo.getHostAddresses()[0];
        int port = employeeServiceInfo.getPort();*/
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


//    private void discoverEmployeeService(String service_type) {
//
//        System.out.println("Trying to discover employee service...");
//        try {
//            // Create a JmDNS instance
//            System.out.println("Create JmDNS");
//            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
//            System.out.println(jmdns);
//            System.out.println("Create listener");
//            jmdns.addServiceListener(service_type, new ServiceListener() {
//
//                @Override
//                public void serviceResolved(ServiceEvent event) {
//                    System.out.println("Employee Service resolved: " + event.getInfo());
//
//                    employeeServiceInfo = event.getInfo();
//
//                    int port = employeeServiceInfo.getPort();
//
//                    System.out.println("resolving " + service_type + " with properties ...");
//                    System.out.println("\t port: " + port);
//                    System.out.println("\t type:" + event.getType());
//                    System.out.println("\t name: " + event.getName());
//                    System.out.println("\t description/properties: " + employeeServiceInfo.getNiceTextString());
//                    System.out.println("\t host: " + employeeServiceInfo.getHostAddresses()[0]);
//
//
//                }
//
//                @Override
//                public void serviceRemoved(ServiceEvent event) {
//                    System.out.println("Employee Service removed: " + event.getInfo());
//
//
//                }
//
//                @Override
//                public void serviceAdded(ServiceEvent event) {
//                    System.out.println("Employee Service added: " + event.getInfo());
//
//
//                }
//            });
//
//            // Wait a bit
//            Thread.sleep(2000);
//
//            jmdns.close();
//
//        } catch (UnknownHostException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Warehouse Services Controller");
        frame.setBounds(100, 100, 800, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);
        // show frame in the center of the display window
        frame.setLocationRelativeTo(null);
        // Main tabbed pane
        mainTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(mainTabbedPane);

        employeeTab = new JTabbedPane(JTabbedPane.TOP);
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

                GetAllEmployeesRequest request = GetAllEmployeesRequest.newBuilder().build();
                StreamObserver<GetEmployeeResponse> responseStreamObserver = new StreamObserver<GetEmployeeResponse>() {
                    int count = 0;
                    @Override
                    public void onNext(GetEmployeeResponse response) {
                        employeeTextArea.append(response.getEmployeeDetails() + "\n");
                        count += 1;
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            // TODO Auto-generated catch block
                            ex.printStackTrace();
                        }
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


        JScrollPane scrollPane = new JScrollPane(employeeTextArea);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_searchEmployee.add(scrollPane);

        stockTab = new JTabbedPane(JTabbedPane.TOP);
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
                    }
                }

                ProductRequest request = ProductRequest.newBuilder().setStockNumber(num).build();
                StreamObserver<ProductResponse> responseStreamObserver = new StreamObserver<ProductResponse>() {
                    @Override
                    public void onNext(ProductResponse response) {
                        if (response.getStockNumber() != -1) {
                            stockTextArea.append("Product{no." + response.getStockNumber() + ", " + response.getDescription() +
                                    ", price:" + response.getPrice() + ", qty:" + response.getQty() + "\n");
                        } else {
                            stockTextArea.append(response.getDescription()+ "\n");
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            // TODO Auto-generated catch block
                            ex.printStackTrace();
                        }
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
        descriptionField.setColumns(14);
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

        // add a label to display the response
        lblAddProduct = new JLabel("");
        panel_service_addProduct.add(lblAddProduct);

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


        panel_service_searchStock.add(btnGetProduct);
        panel_service_searchStock.add(btnClearStockResults);


        stockTextArea = new JTextArea(23, 65);
        stockTextArea.setLineWrap(true);
        stockTextArea.setWrapStyleWord(true);


        JScrollPane scrollPaneStock = new JScrollPane(stockTextArea);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_searchStock.add(scrollPaneStock);


        JPanel panel_service_stock = new JPanel();
        mainTabbedPane.addTab("Order", null, panel_service_stock, null);
        panel_service_stock.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    }

}
