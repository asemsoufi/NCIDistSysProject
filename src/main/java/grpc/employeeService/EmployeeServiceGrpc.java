package grpc.employeeService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: employee.proto")
public final class EmployeeServiceGrpc {

  private EmployeeServiceGrpc() {}

  public static final String SERVICE_NAME = "employeeService.EmployeeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.employeeService.AddEmployeeRequest,
      grpc.employeeService.AddEmployeeResponse> getAddEmployeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addEmployee",
      requestType = grpc.employeeService.AddEmployeeRequest.class,
      responseType = grpc.employeeService.AddEmployeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.employeeService.AddEmployeeRequest,
      grpc.employeeService.AddEmployeeResponse> getAddEmployeeMethod() {
    io.grpc.MethodDescriptor<grpc.employeeService.AddEmployeeRequest, grpc.employeeService.AddEmployeeResponse> getAddEmployeeMethod;
    if ((getAddEmployeeMethod = EmployeeServiceGrpc.getAddEmployeeMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getAddEmployeeMethod = EmployeeServiceGrpc.getAddEmployeeMethod) == null) {
          EmployeeServiceGrpc.getAddEmployeeMethod = getAddEmployeeMethod = 
              io.grpc.MethodDescriptor.<grpc.employeeService.AddEmployeeRequest, grpc.employeeService.AddEmployeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "employeeService.EmployeeService", "addEmployee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.employeeService.AddEmployeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.employeeService.AddEmployeeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("addEmployee"))
                  .build();
          }
        }
     }
     return getAddEmployeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.employeeService.GetEmployeeRequest,
      grpc.employeeService.GetEmployeeResponse> getGetEmployeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEmployee",
      requestType = grpc.employeeService.GetEmployeeRequest.class,
      responseType = grpc.employeeService.GetEmployeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.employeeService.GetEmployeeRequest,
      grpc.employeeService.GetEmployeeResponse> getGetEmployeeMethod() {
    io.grpc.MethodDescriptor<grpc.employeeService.GetEmployeeRequest, grpc.employeeService.GetEmployeeResponse> getGetEmployeeMethod;
    if ((getGetEmployeeMethod = EmployeeServiceGrpc.getGetEmployeeMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getGetEmployeeMethod = EmployeeServiceGrpc.getGetEmployeeMethod) == null) {
          EmployeeServiceGrpc.getGetEmployeeMethod = getGetEmployeeMethod = 
              io.grpc.MethodDescriptor.<grpc.employeeService.GetEmployeeRequest, grpc.employeeService.GetEmployeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "employeeService.EmployeeService", "getEmployee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.employeeService.GetEmployeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.employeeService.GetEmployeeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("getEmployee"))
                  .build();
          }
        }
     }
     return getGetEmployeeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.employeeService.GetAllEmployeesRequest,
      grpc.employeeService.GetEmployeeResponse> getGetAllEmployeesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllEmployees",
      requestType = grpc.employeeService.GetAllEmployeesRequest.class,
      responseType = grpc.employeeService.GetEmployeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.employeeService.GetAllEmployeesRequest,
      grpc.employeeService.GetEmployeeResponse> getGetAllEmployeesMethod() {
    io.grpc.MethodDescriptor<grpc.employeeService.GetAllEmployeesRequest, grpc.employeeService.GetEmployeeResponse> getGetAllEmployeesMethod;
    if ((getGetAllEmployeesMethod = EmployeeServiceGrpc.getGetAllEmployeesMethod) == null) {
      synchronized (EmployeeServiceGrpc.class) {
        if ((getGetAllEmployeesMethod = EmployeeServiceGrpc.getGetAllEmployeesMethod) == null) {
          EmployeeServiceGrpc.getGetAllEmployeesMethod = getGetAllEmployeesMethod = 
              io.grpc.MethodDescriptor.<grpc.employeeService.GetAllEmployeesRequest, grpc.employeeService.GetEmployeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "employeeService.EmployeeService", "getAllEmployees"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.employeeService.GetAllEmployeesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.employeeService.GetEmployeeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EmployeeServiceMethodDescriptorSupplier("getAllEmployees"))
                  .build();
          }
        }
     }
     return getGetAllEmployeesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EmployeeServiceStub newStub(io.grpc.Channel channel) {
    return new EmployeeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmployeeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EmployeeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EmployeeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EmployeeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class EmployeeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addEmployee(grpc.employeeService.AddEmployeeRequest request,
        io.grpc.stub.StreamObserver<grpc.employeeService.AddEmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddEmployeeMethod(), responseObserver);
    }

    /**
     */
    public void getEmployee(grpc.employeeService.GetEmployeeRequest request,
        io.grpc.stub.StreamObserver<grpc.employeeService.GetEmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEmployeeMethod(), responseObserver);
    }

    /**
     */
    public void getAllEmployees(grpc.employeeService.GetAllEmployeesRequest request,
        io.grpc.stub.StreamObserver<grpc.employeeService.GetEmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllEmployeesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddEmployeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.employeeService.AddEmployeeRequest,
                grpc.employeeService.AddEmployeeResponse>(
                  this, METHODID_ADD_EMPLOYEE)))
          .addMethod(
            getGetEmployeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.employeeService.GetEmployeeRequest,
                grpc.employeeService.GetEmployeeResponse>(
                  this, METHODID_GET_EMPLOYEE)))
          .addMethod(
            getGetAllEmployeesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.employeeService.GetAllEmployeesRequest,
                grpc.employeeService.GetEmployeeResponse>(
                  this, METHODID_GET_ALL_EMPLOYEES)))
          .build();
    }
  }

  /**
   */
  public static final class EmployeeServiceStub extends io.grpc.stub.AbstractStub<EmployeeServiceStub> {
    private EmployeeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeServiceStub(channel, callOptions);
    }

    /**
     */
    public void addEmployee(grpc.employeeService.AddEmployeeRequest request,
        io.grpc.stub.StreamObserver<grpc.employeeService.AddEmployeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddEmployeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmployee(grpc.employeeService.GetEmployeeRequest request,
        io.grpc.stub.StreamObserver<grpc.employeeService.GetEmployeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEmployeeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllEmployees(grpc.employeeService.GetAllEmployeesRequest request,
        io.grpc.stub.StreamObserver<grpc.employeeService.GetEmployeeResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllEmployeesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EmployeeServiceBlockingStub extends io.grpc.stub.AbstractStub<EmployeeServiceBlockingStub> {
    private EmployeeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.employeeService.AddEmployeeResponse addEmployee(grpc.employeeService.AddEmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddEmployeeMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.employeeService.GetEmployeeResponse getEmployee(grpc.employeeService.GetEmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEmployeeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.employeeService.GetEmployeeResponse> getAllEmployees(
        grpc.employeeService.GetAllEmployeesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllEmployeesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EmployeeServiceFutureStub extends io.grpc.stub.AbstractStub<EmployeeServiceFutureStub> {
    private EmployeeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EmployeeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmployeeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EmployeeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.employeeService.AddEmployeeResponse> addEmployee(
        grpc.employeeService.AddEmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddEmployeeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.employeeService.GetEmployeeResponse> getEmployee(
        grpc.employeeService.GetEmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEmployeeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_EMPLOYEE = 0;
  private static final int METHODID_GET_EMPLOYEE = 1;
  private static final int METHODID_GET_ALL_EMPLOYEES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EmployeeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EmployeeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_EMPLOYEE:
          serviceImpl.addEmployee((grpc.employeeService.AddEmployeeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.employeeService.AddEmployeeResponse>) responseObserver);
          break;
        case METHODID_GET_EMPLOYEE:
          serviceImpl.getEmployee((grpc.employeeService.GetEmployeeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.employeeService.GetEmployeeResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_EMPLOYEES:
          serviceImpl.getAllEmployees((grpc.employeeService.GetAllEmployeesRequest) request,
              (io.grpc.stub.StreamObserver<grpc.employeeService.GetEmployeeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmployeeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.employeeService.EmployeeServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmployeeService");
    }
  }

  private static final class EmployeeServiceFileDescriptorSupplier
      extends EmployeeServiceBaseDescriptorSupplier {
    EmployeeServiceFileDescriptorSupplier() {}
  }

  private static final class EmployeeServiceMethodDescriptorSupplier
      extends EmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EmployeeServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EmployeeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EmployeeServiceFileDescriptorSupplier())
              .addMethod(getAddEmployeeMethod())
              .addMethod(getGetEmployeeMethod())
              .addMethod(getGetAllEmployeesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
