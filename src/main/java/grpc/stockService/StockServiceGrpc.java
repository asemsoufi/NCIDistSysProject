package grpc.stockService;

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
    comments = "Source: stock.proto")
public final class StockServiceGrpc {

  private StockServiceGrpc() {}

  public static final String SERVICE_NAME = "stockService.StockService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.stockService.UpdateProductStockRequest,
      grpc.stockService.UpdateProductStockResponse> getUpdateProductStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateProductStock",
      requestType = grpc.stockService.UpdateProductStockRequest.class,
      responseType = grpc.stockService.UpdateProductStockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.stockService.UpdateProductStockRequest,
      grpc.stockService.UpdateProductStockResponse> getUpdateProductStockMethod() {
    io.grpc.MethodDescriptor<grpc.stockService.UpdateProductStockRequest, grpc.stockService.UpdateProductStockResponse> getUpdateProductStockMethod;
    if ((getUpdateProductStockMethod = StockServiceGrpc.getUpdateProductStockMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getUpdateProductStockMethod = StockServiceGrpc.getUpdateProductStockMethod) == null) {
          StockServiceGrpc.getUpdateProductStockMethod = getUpdateProductStockMethod = 
              io.grpc.MethodDescriptor.<grpc.stockService.UpdateProductStockRequest, grpc.stockService.UpdateProductStockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "stockService.StockService", "updateProductStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.UpdateProductStockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.UpdateProductStockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("updateProductStock"))
                  .build();
          }
        }
     }
     return getUpdateProductStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.stockService.StockLevelRequest,
      grpc.stockService.StockLevelResponse> getGetStockLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStockLevel",
      requestType = grpc.stockService.StockLevelRequest.class,
      responseType = grpc.stockService.StockLevelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.stockService.StockLevelRequest,
      grpc.stockService.StockLevelResponse> getGetStockLevelMethod() {
    io.grpc.MethodDescriptor<grpc.stockService.StockLevelRequest, grpc.stockService.StockLevelResponse> getGetStockLevelMethod;
    if ((getGetStockLevelMethod = StockServiceGrpc.getGetStockLevelMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetStockLevelMethod = StockServiceGrpc.getGetStockLevelMethod) == null) {
          StockServiceGrpc.getGetStockLevelMethod = getGetStockLevelMethod = 
              io.grpc.MethodDescriptor.<grpc.stockService.StockLevelRequest, grpc.stockService.StockLevelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "stockService.StockService", "getStockLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.StockLevelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.StockLevelResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("getStockLevel"))
                  .build();
          }
        }
     }
     return getGetStockLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.stockService.UpdateProductStockRequest,
      grpc.stockService.UpdateProductStockResponse> getUpdateStockLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStockLevel",
      requestType = grpc.stockService.UpdateProductStockRequest.class,
      responseType = grpc.stockService.UpdateProductStockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.stockService.UpdateProductStockRequest,
      grpc.stockService.UpdateProductStockResponse> getUpdateStockLevelMethod() {
    io.grpc.MethodDescriptor<grpc.stockService.UpdateProductStockRequest, grpc.stockService.UpdateProductStockResponse> getUpdateStockLevelMethod;
    if ((getUpdateStockLevelMethod = StockServiceGrpc.getUpdateStockLevelMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getUpdateStockLevelMethod = StockServiceGrpc.getUpdateStockLevelMethod) == null) {
          StockServiceGrpc.getUpdateStockLevelMethod = getUpdateStockLevelMethod = 
              io.grpc.MethodDescriptor.<grpc.stockService.UpdateProductStockRequest, grpc.stockService.UpdateProductStockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "stockService.StockService", "updateStockLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.UpdateProductStockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.UpdateProductStockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("updateStockLevel"))
                  .build();
          }
        }
     }
     return getUpdateStockLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StockServiceStub newStub(io.grpc.Channel channel) {
    return new StockServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StockServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void updateProductStock(grpc.stockService.UpdateProductStockRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateProductStockMethod(), responseObserver);
    }

    /**
     */
    public void getStockLevel(grpc.stockService.StockLevelRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.StockLevelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockLevelMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockRequest> updateStockLevel(
        io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateStockLevelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateProductStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.stockService.UpdateProductStockRequest,
                grpc.stockService.UpdateProductStockResponse>(
                  this, METHODID_UPDATE_PRODUCT_STOCK)))
          .addMethod(
            getGetStockLevelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.stockService.StockLevelRequest,
                grpc.stockService.StockLevelResponse>(
                  this, METHODID_GET_STOCK_LEVEL)))
          .addMethod(
            getUpdateStockLevelMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.stockService.UpdateProductStockRequest,
                grpc.stockService.UpdateProductStockResponse>(
                  this, METHODID_UPDATE_STOCK_LEVEL)))
          .build();
    }
  }

  /**
   */
  public static final class StockServiceStub extends io.grpc.stub.AbstractStub<StockServiceStub> {
    private StockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceStub(channel, callOptions);
    }

    /**
     */
    public void updateProductStock(grpc.stockService.UpdateProductStockRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateProductStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStockLevel(grpc.stockService.StockLevelRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.StockLevelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStockLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockRequest> updateStockLevel(
        io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUpdateStockLevelMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StockServiceBlockingStub extends io.grpc.stub.AbstractStub<StockServiceBlockingStub> {
    private StockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.stockService.UpdateProductStockResponse updateProductStock(grpc.stockService.UpdateProductStockRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateProductStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.stockService.StockLevelResponse getStockLevel(grpc.stockService.StockLevelRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStockLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StockServiceFutureStub extends io.grpc.stub.AbstractStub<StockServiceFutureStub> {
    private StockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.stockService.UpdateProductStockResponse> updateProductStock(
        grpc.stockService.UpdateProductStockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateProductStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.stockService.StockLevelResponse> getStockLevel(
        grpc.stockService.StockLevelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_PRODUCT_STOCK = 0;
  private static final int METHODID_GET_STOCK_LEVEL = 1;
  private static final int METHODID_UPDATE_STOCK_LEVEL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StockServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_PRODUCT_STOCK:
          serviceImpl.updateProductStock((grpc.stockService.UpdateProductStockRequest) request,
              (io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockResponse>) responseObserver);
          break;
        case METHODID_GET_STOCK_LEVEL:
          serviceImpl.getStockLevel((grpc.stockService.StockLevelRequest) request,
              (io.grpc.stub.StreamObserver<grpc.stockService.StockLevelResponse>) responseObserver);
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
        case METHODID_UPDATE_STOCK_LEVEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateStockLevel(
              (io.grpc.stub.StreamObserver<grpc.stockService.UpdateProductStockResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StockServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.stockService.StockServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StockService");
    }
  }

  private static final class StockServiceFileDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier {
    StockServiceFileDescriptorSupplier() {}
  }

  private static final class StockServiceMethodDescriptorSupplier
      extends StockServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StockServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StockServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StockServiceFileDescriptorSupplier())
              .addMethod(getUpdateProductStockMethod())
              .addMethod(getGetStockLevelMethod())
              .addMethod(getUpdateStockLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
