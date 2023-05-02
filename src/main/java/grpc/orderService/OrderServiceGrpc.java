package grpc.orderService;

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
    comments = "Source: order.proto")
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final String SERVICE_NAME = "orderService.OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.orderService.PlaceOrderRequest,
      grpc.orderService.GetOrderResponse> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "placeOrder",
      requestType = grpc.orderService.PlaceOrderRequest.class,
      responseType = grpc.orderService.GetOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.orderService.PlaceOrderRequest,
      grpc.orderService.GetOrderResponse> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<grpc.orderService.PlaceOrderRequest, grpc.orderService.GetOrderResponse> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = OrderServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getPlaceOrderMethod = OrderServiceGrpc.getPlaceOrderMethod) == null) {
          OrderServiceGrpc.getPlaceOrderMethod = getPlaceOrderMethod = 
              io.grpc.MethodDescriptor.<grpc.orderService.PlaceOrderRequest, grpc.orderService.GetOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "orderService.OrderService", "placeOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.PlaceOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.GetOrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("placeOrder"))
                  .build();
          }
        }
     }
     return getPlaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.orderService.CancelOrderRequest,
      grpc.orderService.CancelOrderResponse> getCancelOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cancelOrder",
      requestType = grpc.orderService.CancelOrderRequest.class,
      responseType = grpc.orderService.CancelOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.orderService.CancelOrderRequest,
      grpc.orderService.CancelOrderResponse> getCancelOrderMethod() {
    io.grpc.MethodDescriptor<grpc.orderService.CancelOrderRequest, grpc.orderService.CancelOrderResponse> getCancelOrderMethod;
    if ((getCancelOrderMethod = OrderServiceGrpc.getCancelOrderMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCancelOrderMethod = OrderServiceGrpc.getCancelOrderMethod) == null) {
          OrderServiceGrpc.getCancelOrderMethod = getCancelOrderMethod = 
              io.grpc.MethodDescriptor.<grpc.orderService.CancelOrderRequest, grpc.orderService.CancelOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "orderService.OrderService", "cancelOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.CancelOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.CancelOrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("cancelOrder"))
                  .build();
          }
        }
     }
     return getCancelOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.orderService.GetOrderRequest,
      grpc.orderService.GetOrderResponse> getGetOrderDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOrderDetails",
      requestType = grpc.orderService.GetOrderRequest.class,
      responseType = grpc.orderService.GetOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.orderService.GetOrderRequest,
      grpc.orderService.GetOrderResponse> getGetOrderDetailsMethod() {
    io.grpc.MethodDescriptor<grpc.orderService.GetOrderRequest, grpc.orderService.GetOrderResponse> getGetOrderDetailsMethod;
    if ((getGetOrderDetailsMethod = OrderServiceGrpc.getGetOrderDetailsMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetOrderDetailsMethod = OrderServiceGrpc.getGetOrderDetailsMethod) == null) {
          OrderServiceGrpc.getGetOrderDetailsMethod = getGetOrderDetailsMethod = 
              io.grpc.MethodDescriptor.<grpc.orderService.GetOrderRequest, grpc.orderService.GetOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "orderService.OrderService", "getOrderDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.GetOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.GetOrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("getOrderDetails"))
                  .build();
          }
        }
     }
     return getGetOrderDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.orderService.TotalSalesRequest,
      grpc.orderService.TotalSalesResponse> getGetTotalSalesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getTotalSales",
      requestType = grpc.orderService.TotalSalesRequest.class,
      responseType = grpc.orderService.TotalSalesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.orderService.TotalSalesRequest,
      grpc.orderService.TotalSalesResponse> getGetTotalSalesMethod() {
    io.grpc.MethodDescriptor<grpc.orderService.TotalSalesRequest, grpc.orderService.TotalSalesResponse> getGetTotalSalesMethod;
    if ((getGetTotalSalesMethod = OrderServiceGrpc.getGetTotalSalesMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetTotalSalesMethod = OrderServiceGrpc.getGetTotalSalesMethod) == null) {
          OrderServiceGrpc.getGetTotalSalesMethod = getGetTotalSalesMethod = 
              io.grpc.MethodDescriptor.<grpc.orderService.TotalSalesRequest, grpc.orderService.TotalSalesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "orderService.OrderService", "getTotalSales"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.TotalSalesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.orderService.TotalSalesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("getTotalSales"))
                  .build();
          }
        }
     }
     return getGetTotalSalesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    return new OrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class OrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.orderService.PlaceOrderRequest> placeOrder(
        io.grpc.stub.StreamObserver<grpc.orderService.GetOrderResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getPlaceOrderMethod(), responseObserver);
    }

    /**
     */
    public void cancelOrder(grpc.orderService.CancelOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.orderService.CancelOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelOrderMethod(), responseObserver);
    }

    /**
     */
    public void getOrderDetails(grpc.orderService.GetOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.orderService.GetOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOrderDetailsMethod(), responseObserver);
    }

    /**
     */
    public void getTotalSales(grpc.orderService.TotalSalesRequest request,
        io.grpc.stub.StreamObserver<grpc.orderService.TotalSalesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTotalSalesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPlaceOrderMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.orderService.PlaceOrderRequest,
                grpc.orderService.GetOrderResponse>(
                  this, METHODID_PLACE_ORDER)))
          .addMethod(
            getCancelOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.orderService.CancelOrderRequest,
                grpc.orderService.CancelOrderResponse>(
                  this, METHODID_CANCEL_ORDER)))
          .addMethod(
            getGetOrderDetailsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.orderService.GetOrderRequest,
                grpc.orderService.GetOrderResponse>(
                  this, METHODID_GET_ORDER_DETAILS)))
          .addMethod(
            getGetTotalSalesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.orderService.TotalSalesRequest,
                grpc.orderService.TotalSalesResponse>(
                  this, METHODID_GET_TOTAL_SALES)))
          .build();
    }
  }

  /**
   */
  public static final class OrderServiceStub extends io.grpc.stub.AbstractStub<OrderServiceStub> {
    private OrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.orderService.PlaceOrderRequest> placeOrder(
        io.grpc.stub.StreamObserver<grpc.orderService.GetOrderResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void cancelOrder(grpc.orderService.CancelOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.orderService.CancelOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrderDetails(grpc.orderService.GetOrderRequest request,
        io.grpc.stub.StreamObserver<grpc.orderService.GetOrderResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetOrderDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTotalSales(grpc.orderService.TotalSalesRequest request,
        io.grpc.stub.StreamObserver<grpc.orderService.TotalSalesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTotalSalesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class OrderServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.orderService.CancelOrderResponse cancelOrder(grpc.orderService.CancelOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.orderService.GetOrderResponse> getOrderDetails(
        grpc.orderService.GetOrderRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetOrderDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.orderService.TotalSalesResponse getTotalSales(grpc.orderService.TotalSalesRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTotalSalesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OrderServiceFutureStub extends io.grpc.stub.AbstractStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.orderService.CancelOrderResponse> cancelOrder(
        grpc.orderService.CancelOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.orderService.TotalSalesResponse> getTotalSales(
        grpc.orderService.TotalSalesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTotalSalesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CANCEL_ORDER = 0;
  private static final int METHODID_GET_ORDER_DETAILS = 1;
  private static final int METHODID_GET_TOTAL_SALES = 2;
  private static final int METHODID_PLACE_ORDER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CANCEL_ORDER:
          serviceImpl.cancelOrder((grpc.orderService.CancelOrderRequest) request,
              (io.grpc.stub.StreamObserver<grpc.orderService.CancelOrderResponse>) responseObserver);
          break;
        case METHODID_GET_ORDER_DETAILS:
          serviceImpl.getOrderDetails((grpc.orderService.GetOrderRequest) request,
              (io.grpc.stub.StreamObserver<grpc.orderService.GetOrderResponse>) responseObserver);
          break;
        case METHODID_GET_TOTAL_SALES:
          serviceImpl.getTotalSales((grpc.orderService.TotalSalesRequest) request,
              (io.grpc.stub.StreamObserver<grpc.orderService.TotalSalesResponse>) responseObserver);
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
        case METHODID_PLACE_ORDER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.placeOrder(
              (io.grpc.stub.StreamObserver<grpc.orderService.GetOrderResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.orderService.OrderServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getPlaceOrderMethod())
              .addMethod(getCancelOrderMethod())
              .addMethod(getGetOrderDetailsMethod())
              .addMethod(getGetTotalSalesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
