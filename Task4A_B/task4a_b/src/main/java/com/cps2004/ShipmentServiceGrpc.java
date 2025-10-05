package com.cps2004;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: shipment_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ShipmentServiceGrpc {

  private ShipmentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.cps2004.ShipmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest,
      com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse> getCalculateTotalPriceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateTotalPrice",
      requestType = com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest.class,
      responseType = com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest,
      com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse> getCalculateTotalPriceMethod() {
    io.grpc.MethodDescriptor<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest, com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse> getCalculateTotalPriceMethod;
    if ((getCalculateTotalPriceMethod = ShipmentServiceGrpc.getCalculateTotalPriceMethod) == null) {
      synchronized (ShipmentServiceGrpc.class) {
        if ((getCalculateTotalPriceMethod = ShipmentServiceGrpc.getCalculateTotalPriceMethod) == null) {
          ShipmentServiceGrpc.getCalculateTotalPriceMethod = getCalculateTotalPriceMethod =
              io.grpc.MethodDescriptor.<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest, com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CalculateTotalPrice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ShipmentServiceMethodDescriptorSupplier("CalculateTotalPrice"))
              .build();
        }
      }
    }
    return getCalculateTotalPriceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ShipmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShipmentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShipmentServiceStub>() {
        @java.lang.Override
        public ShipmentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShipmentServiceStub(channel, callOptions);
        }
      };
    return ShipmentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ShipmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShipmentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShipmentServiceBlockingStub>() {
        @java.lang.Override
        public ShipmentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShipmentServiceBlockingStub(channel, callOptions);
        }
      };
    return ShipmentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ShipmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ShipmentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ShipmentServiceFutureStub>() {
        @java.lang.Override
        public ShipmentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ShipmentServiceFutureStub(channel, callOptions);
        }
      };
    return ShipmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void calculateTotalPrice(com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest request,
        io.grpc.stub.StreamObserver<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCalculateTotalPriceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ShipmentService.
   */
  public static abstract class ShipmentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ShipmentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ShipmentService.
   */
  public static final class ShipmentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ShipmentServiceStub> {
    private ShipmentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShipmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShipmentServiceStub(channel, callOptions);
    }

    /**
     */
    public void calculateTotalPrice(com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest request,
        io.grpc.stub.StreamObserver<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateTotalPriceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ShipmentService.
   */
  public static final class ShipmentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ShipmentServiceBlockingStub> {
    private ShipmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShipmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShipmentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse calculateTotalPrice(com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateTotalPriceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ShipmentService.
   */
  public static final class ShipmentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ShipmentServiceFutureStub> {
    private ShipmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ShipmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ShipmentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse> calculateTotalPrice(
        com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateTotalPriceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_TOTAL_PRICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_TOTAL_PRICE:
          serviceImpl.calculateTotalPrice((com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest) request,
              (io.grpc.stub.StreamObserver<com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCalculateTotalPriceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceRequest,
              com.cps2004.ShipmentServiceOuterClass.CalculateTotalPriceResponse>(
                service, METHODID_CALCULATE_TOTAL_PRICE)))
        .build();
  }

  private static abstract class ShipmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ShipmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.cps2004.ShipmentServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ShipmentService");
    }
  }

  private static final class ShipmentServiceFileDescriptorSupplier
      extends ShipmentServiceBaseDescriptorSupplier {
    ShipmentServiceFileDescriptorSupplier() {}
  }

  private static final class ShipmentServiceMethodDescriptorSupplier
      extends ShipmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ShipmentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ShipmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ShipmentServiceFileDescriptorSupplier())
              .addMethod(getCalculateTotalPriceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
