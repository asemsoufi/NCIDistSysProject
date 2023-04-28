package client;

import grpc.employeeService.EmployeeServiceGrpc;
import grpc.employeeService.GetEmployeeRequest;
import grpc.employeeService.GetEmployeeResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

public class MainGUIApplication {

    private static EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    private static EmployeeServiceGrpc.EmployeeServiceStub asyncStub;

    private ServiceInfo employeeServiceInfo;


    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
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
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Number 1");
        panel_service_1.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_1.add(textNumber1);
        textNumber1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Number 2");
        panel_service_1.add(lblNewLabel_2);

        textNumber2 = new JTextField();
        panel_service_1.add(textNumber2);
        textNumber2.setColumns(10);


        JComboBox comboOperation = new JComboBox();
        comboOperation.setModel(new DefaultComboBoxModel(new String[]{"Employee Services", "Order Services", "Stock Services"}));
        panel_service_1.add(comboOperation);


        JButton btnCalculate = new JButton("Process");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(textNumber1.getText());
                //int num2 = Integer.parseInt(textNumber2.getText());

                //int index = comboOperation.getSelectedIndex();
                //Operation operation = Operation.forNumber(index);

                GetEmployeeRequest req = GetEmployeeRequest.newBuilder().setEmployeeNumber(num1).build();

                GetEmployeeResponse response = blockingStub.getEmployee(req);

                textResponse.append("reply:\n" + response.getEmployeeDetails() + "\n");

                System.out.println("result:\n" + response.getEmployeeDetails());

            }
        });
        panel_service_1.add(btnCalculate);

        textResponse = new JTextArea(3, 20);
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
