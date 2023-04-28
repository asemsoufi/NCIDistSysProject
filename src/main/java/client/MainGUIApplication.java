package client;

import grpc.employeeService.EmployeeServiceGrpc;
import grpc.employeeService.GetAllEmployeesRequest;
import grpc.employeeService.GetEmployeeRequest;
import grpc.employeeService.GetEmployeeResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

public class MainGUIApplication {

    private static EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    private static EmployeeServiceGrpc.EmployeeServiceStub asyncStub;

    private ServiceInfo employeeServiceInfo;


    private JFrame frame;
    private JTextField textNumber1;
    private JTextArea textResponse;

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
/*
        String employee_service_type = "_employee._tcp.local.";
        discoverEmployeeService(employee_service_type);

        String host = employeeServiceInfo.getHostAddresses()[0];
        int port = employeeServiceInfo.getPort();*/

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        //stubs -- generate from proto
        blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);

        asyncStub = EmployeeServiceGrpc.newStub(channel);


        initialize();
    }


    private void discoverEmployeeService(String service_type) {

        System.out.println("Trying to discover employee service...");
        try {
            // Create a JmDNS instance
            System.out.println("Create JmDNS");
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println(jmdns);
            System.out.println("Create listener");
            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Employee Service resolved: " + event.getInfo());

                    employeeServiceInfo = event.getInfo();

                    int port = employeeServiceInfo.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:" + event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + employeeServiceInfo.getNiceTextString());
                    System.out.println("\t host: " + employeeServiceInfo.getHostAddresses()[0]);


                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Employee Service removed: " + event.getInfo());


                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Employee Service added: " + event.getInfo());


                }
            });

            // Wait a bit
            Thread.sleep(2000);

            jmdns.close();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Client - Service Controller");
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Employee Number");
        panel_service_1.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_1.add(textNumber1);
        textNumber1.setColumns(10);



        JComboBox comboOperation = new JComboBox();
        comboOperation.setModel(new DefaultComboBoxModel(new String[]{"Employee Services", "Order Services", "Stock Services"}));
        panel_service_1.add(comboOperation);


        JButton btnGetEmployee = new JButton("Find Employee");
        btnGetEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1;

                try {
                    num1 = Integer.parseInt(textNumber1.getText());
                } catch (NumberFormatException ex) {
                    textResponse.append("reply:\n" + "Enter a valid Employee number!" + "\n");
                    return;
                }
                //int num2 = Integer.parseInt(textNumber2.getText());

                //int index = comboOperation.getSelectedIndex();
                //Operation operation = Operation.forNumber(index);

                GetEmployeeRequest req = GetEmployeeRequest.newBuilder().setEmployeeNumber(num1).build();

                GetEmployeeResponse response = blockingStub.getEmployee(req);

                textResponse.append("reply:\n" + response.getEmployeeDetails() + "\n");

                System.out.println("result:\n" + response.getEmployeeDetails());

            }
        });

        JButton btnGetAllEmployees = new JButton("List All Employees");
        btnGetAllEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textResponse.setText("");

                GetAllEmployeesRequest request = GetAllEmployeesRequest.newBuilder().build();

               /* Iterator<GetEmployeeResponse> responses = blockingStub.getAllEmployees(request);
                while (responses.hasNext()) {
                    GetEmployeeResponse response = responses.next();
                    textResponse.append("reply:\n" + response.getEmployeeDetails() + "\n");
                }*/

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
                        System.out.println("Completed listing all " + count + " employees.");
                    }

                };


                asyncStub.getAllEmployees(request, responseStreamObserver);
            }
        });

        panel_service_1.add(btnGetEmployee);
        panel_service_1.add(btnGetAllEmployees);

        textResponse = new JTextArea(50, 65);
        textResponse.setLineWrap(true);
        textResponse.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textResponse);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_1.add(scrollPane);


        JPanel panel_service_2 = new JPanel();
        frame.getContentPane().add(panel_service_2);

        JPanel panel_service_3 = new JPanel();
        frame.getContentPane().add(panel_service_3);


    }

}
