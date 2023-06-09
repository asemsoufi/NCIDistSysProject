// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: order.proto

package grpc.orderService;

/**
 * Protobuf type {@code orderService.PlaceOrderRequest}
 */
public  final class PlaceOrderRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:orderService.PlaceOrderRequest)
    PlaceOrderRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PlaceOrderRequest.newBuilder() to construct.
  private PlaceOrderRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PlaceOrderRequest() {
    stockNumber_ = 0;
    prodDescription_ = "";
    prodPrice_ = 0F;
    prodQty_ = 0;
    orderedQty_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PlaceOrderRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            stockNumber_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            prodDescription_ = s;
            break;
          }
          case 29: {

            prodPrice_ = input.readFloat();
            break;
          }
          case 32: {

            prodQty_ = input.readInt32();
            break;
          }
          case 40: {

            orderedQty_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.orderService.OrderServiceImpl.internal_static_orderService_PlaceOrderRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.orderService.OrderServiceImpl.internal_static_orderService_PlaceOrderRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.orderService.PlaceOrderRequest.class, grpc.orderService.PlaceOrderRequest.Builder.class);
  }

  public static final int STOCKNUMBER_FIELD_NUMBER = 1;
  private int stockNumber_;
  /**
   * <code>int32 stockNumber = 1;</code>
   */
  public int getStockNumber() {
    return stockNumber_;
  }

  public static final int PRODDESCRIPTION_FIELD_NUMBER = 2;
  private volatile java.lang.Object prodDescription_;
  /**
   * <code>string prodDescription = 2;</code>
   */
  public java.lang.String getProdDescription() {
    java.lang.Object ref = prodDescription_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      prodDescription_ = s;
      return s;
    }
  }
  /**
   * <code>string prodDescription = 2;</code>
   */
  public com.google.protobuf.ByteString
      getProdDescriptionBytes() {
    java.lang.Object ref = prodDescription_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      prodDescription_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRODPRICE_FIELD_NUMBER = 3;
  private float prodPrice_;
  /**
   * <code>float prodPrice = 3;</code>
   */
  public float getProdPrice() {
    return prodPrice_;
  }

  public static final int PRODQTY_FIELD_NUMBER = 4;
  private int prodQty_;
  /**
   * <code>int32 prodQty = 4;</code>
   */
  public int getProdQty() {
    return prodQty_;
  }

  public static final int ORDEREDQTY_FIELD_NUMBER = 5;
  private int orderedQty_;
  /**
   * <code>int32 orderedQty = 5;</code>
   */
  public int getOrderedQty() {
    return orderedQty_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (stockNumber_ != 0) {
      output.writeInt32(1, stockNumber_);
    }
    if (!getProdDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, prodDescription_);
    }
    if (prodPrice_ != 0F) {
      output.writeFloat(3, prodPrice_);
    }
    if (prodQty_ != 0) {
      output.writeInt32(4, prodQty_);
    }
    if (orderedQty_ != 0) {
      output.writeInt32(5, orderedQty_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (stockNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, stockNumber_);
    }
    if (!getProdDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, prodDescription_);
    }
    if (prodPrice_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, prodPrice_);
    }
    if (prodQty_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, prodQty_);
    }
    if (orderedQty_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, orderedQty_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.orderService.PlaceOrderRequest)) {
      return super.equals(obj);
    }
    grpc.orderService.PlaceOrderRequest other = (grpc.orderService.PlaceOrderRequest) obj;

    boolean result = true;
    result = result && (getStockNumber()
        == other.getStockNumber());
    result = result && getProdDescription()
        .equals(other.getProdDescription());
    result = result && (
        java.lang.Float.floatToIntBits(getProdPrice())
        == java.lang.Float.floatToIntBits(
            other.getProdPrice()));
    result = result && (getProdQty()
        == other.getProdQty());
    result = result && (getOrderedQty()
        == other.getOrderedQty());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STOCKNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getStockNumber();
    hash = (37 * hash) + PRODDESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getProdDescription().hashCode();
    hash = (37 * hash) + PRODPRICE_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getProdPrice());
    hash = (37 * hash) + PRODQTY_FIELD_NUMBER;
    hash = (53 * hash) + getProdQty();
    hash = (37 * hash) + ORDEREDQTY_FIELD_NUMBER;
    hash = (53 * hash) + getOrderedQty();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.orderService.PlaceOrderRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.orderService.PlaceOrderRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.orderService.PlaceOrderRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.orderService.PlaceOrderRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.orderService.PlaceOrderRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code orderService.PlaceOrderRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:orderService.PlaceOrderRequest)
      grpc.orderService.PlaceOrderRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.orderService.OrderServiceImpl.internal_static_orderService_PlaceOrderRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.orderService.OrderServiceImpl.internal_static_orderService_PlaceOrderRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.orderService.PlaceOrderRequest.class, grpc.orderService.PlaceOrderRequest.Builder.class);
    }

    // Construct using grpc.orderService.PlaceOrderRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      stockNumber_ = 0;

      prodDescription_ = "";

      prodPrice_ = 0F;

      prodQty_ = 0;

      orderedQty_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.orderService.OrderServiceImpl.internal_static_orderService_PlaceOrderRequest_descriptor;
    }

    @java.lang.Override
    public grpc.orderService.PlaceOrderRequest getDefaultInstanceForType() {
      return grpc.orderService.PlaceOrderRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.orderService.PlaceOrderRequest build() {
      grpc.orderService.PlaceOrderRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.orderService.PlaceOrderRequest buildPartial() {
      grpc.orderService.PlaceOrderRequest result = new grpc.orderService.PlaceOrderRequest(this);
      result.stockNumber_ = stockNumber_;
      result.prodDescription_ = prodDescription_;
      result.prodPrice_ = prodPrice_;
      result.prodQty_ = prodQty_;
      result.orderedQty_ = orderedQty_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.orderService.PlaceOrderRequest) {
        return mergeFrom((grpc.orderService.PlaceOrderRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.orderService.PlaceOrderRequest other) {
      if (other == grpc.orderService.PlaceOrderRequest.getDefaultInstance()) return this;
      if (other.getStockNumber() != 0) {
        setStockNumber(other.getStockNumber());
      }
      if (!other.getProdDescription().isEmpty()) {
        prodDescription_ = other.prodDescription_;
        onChanged();
      }
      if (other.getProdPrice() != 0F) {
        setProdPrice(other.getProdPrice());
      }
      if (other.getProdQty() != 0) {
        setProdQty(other.getProdQty());
      }
      if (other.getOrderedQty() != 0) {
        setOrderedQty(other.getOrderedQty());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.orderService.PlaceOrderRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.orderService.PlaceOrderRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int stockNumber_ ;
    /**
     * <code>int32 stockNumber = 1;</code>
     */
    public int getStockNumber() {
      return stockNumber_;
    }
    /**
     * <code>int32 stockNumber = 1;</code>
     */
    public Builder setStockNumber(int value) {
      
      stockNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 stockNumber = 1;</code>
     */
    public Builder clearStockNumber() {
      
      stockNumber_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object prodDescription_ = "";
    /**
     * <code>string prodDescription = 2;</code>
     */
    public java.lang.String getProdDescription() {
      java.lang.Object ref = prodDescription_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        prodDescription_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string prodDescription = 2;</code>
     */
    public com.google.protobuf.ByteString
        getProdDescriptionBytes() {
      java.lang.Object ref = prodDescription_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        prodDescription_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string prodDescription = 2;</code>
     */
    public Builder setProdDescription(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      prodDescription_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string prodDescription = 2;</code>
     */
    public Builder clearProdDescription() {
      
      prodDescription_ = getDefaultInstance().getProdDescription();
      onChanged();
      return this;
    }
    /**
     * <code>string prodDescription = 2;</code>
     */
    public Builder setProdDescriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      prodDescription_ = value;
      onChanged();
      return this;
    }

    private float prodPrice_ ;
    /**
     * <code>float prodPrice = 3;</code>
     */
    public float getProdPrice() {
      return prodPrice_;
    }
    /**
     * <code>float prodPrice = 3;</code>
     */
    public Builder setProdPrice(float value) {
      
      prodPrice_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float prodPrice = 3;</code>
     */
    public Builder clearProdPrice() {
      
      prodPrice_ = 0F;
      onChanged();
      return this;
    }

    private int prodQty_ ;
    /**
     * <code>int32 prodQty = 4;</code>
     */
    public int getProdQty() {
      return prodQty_;
    }
    /**
     * <code>int32 prodQty = 4;</code>
     */
    public Builder setProdQty(int value) {
      
      prodQty_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 prodQty = 4;</code>
     */
    public Builder clearProdQty() {
      
      prodQty_ = 0;
      onChanged();
      return this;
    }

    private int orderedQty_ ;
    /**
     * <code>int32 orderedQty = 5;</code>
     */
    public int getOrderedQty() {
      return orderedQty_;
    }
    /**
     * <code>int32 orderedQty = 5;</code>
     */
    public Builder setOrderedQty(int value) {
      
      orderedQty_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 orderedQty = 5;</code>
     */
    public Builder clearOrderedQty() {
      
      orderedQty_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:orderService.PlaceOrderRequest)
  }

  // @@protoc_insertion_point(class_scope:orderService.PlaceOrderRequest)
  private static final grpc.orderService.PlaceOrderRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.orderService.PlaceOrderRequest();
  }

  public static grpc.orderService.PlaceOrderRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PlaceOrderRequest>
      PARSER = new com.google.protobuf.AbstractParser<PlaceOrderRequest>() {
    @java.lang.Override
    public PlaceOrderRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PlaceOrderRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PlaceOrderRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PlaceOrderRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.orderService.PlaceOrderRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

