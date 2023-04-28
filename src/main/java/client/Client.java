package client;

import grpc.employeeService.EmployeeServiceGrpc;
import grpc.employeeService.GetEmployeeRequest;
import grpc.employeeService.GetEmployeeResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    private static EmployeeServiceGrpc.EmployeeServiceBlockingStub blockingStub;
    private static EmployeeServiceGrpc.EmployeeServiceStub asyncStub;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();
        // stubs -- generate from proto
        blockingStub = EmployeeServiceGrpc.newBlockingStub(channel);
        asyncStub = EmployeeServiceGrpc.newStub(channel);
        getEmployee(5002);
    }

    private static void getEmployee(int number) {
        GetEmployeeRequest request = GetEmployeeRequest.newBuilder().setEmployeeNumber(number).build();
        GetEmployeeResponse response = blockingStub.getEmployee(request);
        System.out.println("Response:\n" + response.getEmployeeDetails());
    }
}
