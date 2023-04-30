package client;

import grpc.employeeService.*;
import grpc.orderService.OrderServiceGrpc;
import grpc.stockService.StockServiceGrpc;
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
    private JPanel employeePanel;
    private JPanel orderPanel;
    private JPanel stockPanel;
    private JTextField textNumber1;
    private JLabel lblNewLabel_6;


    public static JTextArea textResponse;

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

        // Employee tab
        JPanel panel_service_searchEmployee = new JPanel();
        JPanel panel_service_addEmployee = new JPanel();
        employeeTab.addTab("Search Employees", null, panel_service_searchEmployee, null);
        employeeTab.addTab("Add Employee", null, panel_service_addEmployee, null);
        panel_service_searchEmployee.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_service_addEmployee.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Employee Number");
        panel_service_searchEmployee.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_searchEmployee.add(textNumber1);
        textNumber1.setColumns(10);



        JButton btnGetEmployee = new JButton("Find Employee");
        btnGetEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1;

                try {
                    num1 = Integer.parseInt(textNumber1.getText());
                } catch (NumberFormatException ex) {
                    textResponse.append("Enter a valid Employee number!" + "\n");
                    return;
                }

                GetEmployeeRequest req = GetEmployeeRequest.newBuilder().setEmployeeNumber(num1).build();
                try {
                    GetEmployeeResponse response = employeeServiceBlockingStub.getEmployee(req);
                    textResponse.append(response.getEmployeeDetails() + "\n");
                }
                catch (Exception ex) {
                    textResponse.append("Server not running!\n");
                }

            }
        });

        JButton btnGetAllEmployees = new JButton("List All Employees");
        btnGetAllEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textResponse.setText("");

                GetAllEmployeesRequest request = GetAllEmployeesRequest.newBuilder().build();
                StreamObserver<GetEmployeeResponse> responseStreamObserver = new StreamObserver<GetEmployeeResponse>() {
                    int count = 0;
                    @Override
                    public void onNext(GetEmployeeResponse response) {
                        textResponse.append(response.getEmployeeDetails() + "\n");
                        count += 1;
                        try {
                            Thread.sleep(200);
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
                        textResponse.append("Completed listing all " + count + " employees.");
                    }

                };

                employeeServiceAsyncStub.getAllEmployees(request, responseStreamObserver);
            }
        });

        JButton btnClearResults = new JButton("Clear Results");
        btnClearResults.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textResponse.setText("");
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
                        lblNewLabel_6.setText(response.getMessage());
                        lblNewLabel_6.setForeground(Color.darkGray);
                    } else {
                        lblNewLabel_6.setText(response.getMessage());
                        lblNewLabel_6.setForeground(Color.RED);
                    }
                } catch (Exception ex) {
                    lblNewLabel_6.setText("Error!");
                    lblNewLabel_6.setForeground(Color.RED);
                }
            }
        });

        // add a label to display the response
        lblNewLabel_6 = new JLabel("");
        panel_service_addEmployee.add(lblNewLabel_6);

        panel_service_searchEmployee.add(btnGetEmployee);
        panel_service_searchEmployee.add(btnGetAllEmployees);
        panel_service_searchEmployee.add(btnClearResults);


        textResponse = new JTextArea(23, 65);
        textResponse.setLineWrap(true);
        textResponse.setWrapStyleWord(true);


        JScrollPane scrollPane = new JScrollPane(textResponse);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_searchEmployee.add(scrollPane);

        JPanel panel_service_order = new JPanel();
        mainTabbedPane.addTab("Orders", null, panel_service_order, null);
        panel_service_order.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        JPanel panel_service_stock = new JPanel();
        mainTabbedPane.addTab("Stock", null, panel_service_stock, null);
        panel_service_stock.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

    }

}
