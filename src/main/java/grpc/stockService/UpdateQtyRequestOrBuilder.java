// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock.proto

package grpc.stockService;

public interface UpdateQtyRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:stockService.UpdateQtyRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 stockNumber = 1;</code>
   */
  int getStockNumber();

  /**
   * <pre>
   * could be a negative number if decreasing quantity
   * </pre>
   *
   * <code>sint32 qty = 2;</code>
   */
  int getQty();
}
