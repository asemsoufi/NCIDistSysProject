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
  private static volatile io.grpc.MethodDescriptor<grpc.stockService.UpdateQtyRequest,
      grpc.stockService.UpdateQtyResponse> getUpdateQtyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateQty",
      requestType = grpc.stockService.UpdateQtyRequest.class,
      responseType = grpc.stockService.UpdateQtyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.stockService.UpdateQtyRequest,
      grpc.stockService.UpdateQtyResponse> getUpdateQtyMethod() {
    io.grpc.MethodDescriptor<grpc.stockService.UpdateQtyRequest, grpc.stockService.UpdateQtyResponse> getUpdateQtyMethod;
    if ((getUpdateQtyMethod = StockServiceGrpc.getUpdateQtyMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getUpdateQtyMethod = StockServiceGrpc.getUpdateQtyMethod) == null) {
          StockServiceGrpc.getUpdateQtyMethod = getUpdateQtyMethod = 
              io.grpc.MethodDescriptor.<grpc.stockService.UpdateQtyRequest, grpc.stockService.UpdateQtyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "stockService.StockService", "updateQty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.UpdateQtyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.UpdateQtyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("updateQty"))
                  .build();
          }
        }
     }
     return getUpdateQtyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.stockService.ProductRequest,
      grpc.stockService.ProductResponse> getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProduct",
      requestType = grpc.stockService.ProductRequest.class,
      responseType = grpc.stockService.ProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.stockService.ProductRequest,
      grpc.stockService.ProductResponse> getGetProductMethod() {
    io.grpc.MethodDescriptor<grpc.stockService.ProductRequest, grpc.stockService.ProductResponse> getGetProductMethod;
    if ((getGetProductMethod = StockServiceGrpc.getGetProductMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getGetProductMethod = StockServiceGrpc.getGetProductMethod) == null) {
          StockServiceGrpc.getGetProductMethod = getGetProductMethod = 
              io.grpc.MethodDescriptor.<grpc.stockService.ProductRequest, grpc.stockService.ProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "stockService.StockService", "getProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.ProductResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("getProduct"))
                  .build();
          }
        }
     }
     return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.stockService.AddProductRequest,
      grpc.stockService.AddProductResponse> getAddProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProduct",
      requestType = grpc.stockService.AddProductRequest.class,
      responseType = grpc.stockService.AddProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.stockService.AddProductRequest,
      grpc.stockService.AddProductResponse> getAddProductMethod() {
    io.grpc.MethodDescriptor<grpc.stockService.AddProductRequest, grpc.stockService.AddProductResponse> getAddProductMethod;
    if ((getAddProductMethod = StockServiceGrpc.getAddProductMethod) == null) {
      synchronized (StockServiceGrpc.class) {
        if ((getAddProductMethod = StockServiceGrpc.getAddProductMethod) == null) {
          StockServiceGrpc.getAddProductMethod = getAddProductMethod = 
              io.grpc.MethodDescriptor.<grpc.stockService.AddProductRequest, grpc.stockService.AddProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "stockService.StockService", "addProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.AddProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.stockService.AddProductResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StockServiceMethodDescriptorSupplier("addProduct"))
                  .build();
          }
        }
     }
     return getAddProductMethod;
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
    public io.grpc.stub.StreamObserver<grpc.stockService.UpdateQtyRequest> updateQty(
        io.grpc.stub.StreamObserver<grpc.stockService.UpdateQtyResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateQtyMethod(), responseObserver);
    }

    /**
     */
    public void getProduct(grpc.stockService.ProductRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.ProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     */
    public void addProduct(grpc.stockService.AddProductRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.AddProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUpdateQtyMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.stockService.UpdateQtyRequest,
                grpc.stockService.UpdateQtyResponse>(
                  this, METHODID_UPDATE_QTY)))
          .addMethod(
            getGetProductMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.stockService.ProductRequest,
                grpc.stockService.ProductResponse>(
                  this, METHODID_GET_PRODUCT)))
          .addMethod(
            getAddProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.stockService.AddProductRequest,
                grpc.stockService.AddProductResponse>(
                  this, METHODID_ADD_PRODUCT)))
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
    public io.grpc.stub.StreamObserver<grpc.stockService.UpdateQtyRequest> updateQty(
        io.grpc.stub.StreamObserver<grpc.stockService.UpdateQtyResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUpdateQtyMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getProduct(grpc.stockService.ProductRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.ProductResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addProduct(grpc.stockService.AddProductRequest request,
        io.grpc.stub.StreamObserver<grpc.stockService.AddProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request, responseObserver);
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
    public java.util.Iterator<grpc.stockService.ProductResponse> getProduct(
        grpc.stockService.ProductRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.stockService.AddProductResponse addProduct(grpc.stockService.AddProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddProductMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<grpc.stockService.AddProductResponse> addProduct(
        grpc.stockService.AddProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT = 0;
  private static final int METHODID_ADD_PRODUCT = 1;
  private static final int METHODID_UPDATE_QTY = 2;

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
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((grpc.stockService.ProductRequest) request,
              (io.grpc.stub.StreamObserver<grpc.stockService.ProductResponse>) responseObserver);
          break;
        case METHODID_ADD_PRODUCT:
          serviceImpl.addProduct((grpc.stockService.AddProductRequest) request,
              (io.grpc.stub.StreamObserver<grpc.stockService.AddProductResponse>) responseObserver);
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
        case METHODID_UPDATE_QTY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateQty(
              (io.grpc.stub.StreamObserver<grpc.stockService.UpdateQtyResponse>) responseObserver);
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
              .addMethod(getUpdateQtyMethod())
              .addMethod(getGetProductMethod())
              .addMethod(getAddProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
