package client;

import grpc.employeeService.AddEmployeeRequest;
import grpc.employeeService.AddEmployeeResponse;
import grpc.employeeService.EmployeeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeGUI {
    private static EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();
        blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
        // create a new swing form with 4 input fields and a submit button
        JFrame frame = new JFrame("Add Employee");
        frame.setBounds(100, 100, 500, 500);
        // list fields vertically
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // show frame in the center of the display window
        frame.setLocationRelativeTo(null);
        // create a new panel to hold the input fields
        JPanel panel = new JPanel();
        // create a new label for the input fields
        JLabel numberLabel = new JLabel("Employee Number");
        JLabel nameLabel = new JLabel("Name");
        JLabel positionLabel = new JLabel("Position");
        JLabel salaryLabel = new JLabel("Salary");
        // create a new text field for the input fields
        JTextField numberField = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField positionField = new JTextField(20);
        JTextField salaryField = new JTextField(20);
        // create a new submit button
        JButton submitButton = new JButton("Submit");
        // show the form
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // panel layout multi raws
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        frame.setBounds(200, 200, 200, 250);
        frame.getContentPane().add(panel);
        // show fields and submit button
        panel.add(numberLabel);
        panel.add(numberField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(positionLabel);
        panel.add(positionField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(submitButton);
        //frame.pack();
        // show the form in the top center of the display window
        frame.setLocationRelativeTo(null);
        // set action listener for the submit button
        submitButton.addActionListener(e -> {
            int empNumber = Integer.parseInt(numberField.getText());
            String name = nameField.getText();
            String position = positionField.getText();
            int salary = Integer.parseInt(salaryField.getText());

            AddEmployeeRequest req = AddEmployeeRequest.newBuilder().setEmployeeNumber(empNumber).setEmployeeName(name).setPosition(position).setSalary(salary).build();
            AddEmployeeResponse response = blockingStub.addEmployee(req);
            if (response.getSuccess()) {
                MainGUIApplication.textResponse.append("Employee successfully added." + "\n");
            } else {
                MainGUIApplication.textResponse.append("Employee not added!" + "\n");
            }
        });
    }
}
