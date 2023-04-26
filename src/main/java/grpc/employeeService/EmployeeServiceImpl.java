// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: employee.proto

package grpc.employeeService;

public final class EmployeeServiceImpl {
  private EmployeeServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employeeService_AddEmployeeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employeeService_AddEmployeeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employeeService_AddEmployeeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employeeService_AddEmployeeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employeeService_GetEmployeeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employeeService_GetEmployeeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employeeService_GetEmployeeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employeeService_GetEmployeeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_employeeService_GetAllEmployeesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_employeeService_GetAllEmployeesRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016employee.proto\022\017employeeService\"d\n\022Add" +
      "EmployeeRequest\022\026\n\016employeeNumber\030\001 \001(\005\022" +
      "\024\n\014employeeName\030\002 \001(\t\022\020\n\010position\030\003 \001(\t\022" +
      "\016\n\006salary\030\004 \001(\005\"&\n\023AddEmployeeResponse\022\017" +
      "\n\007success\030\001 \001(\010\",\n\022GetEmployeeRequest\022\026\n" +
      "\016employeeNumber\030\001 \001(\005\".\n\023GetEmployeeResp" +
      "onse\022\027\n\017employeeDetails\030\001 \001(\t\"\030\n\026GetAllE" +
      "mployeesRequest2\257\002\n\017EmployeeService\022Z\n\013a" +
      "ddEmployee\022#.employeeService.AddEmployee" +
      "Request\032$.employeeService.AddEmployeeRes" +
      "ponse\"\000\022Z\n\013getEmployee\022#.employeeService" +
      ".GetEmployeeRequest\032$.employeeService.Ge" +
      "tEmployeeResponse\"\000\022d\n\017getAllEmployees\022\'" +
      ".employeeService.GetAllEmployeesRequest\032" +
      "$.employeeService.GetEmployeeResponse\"\0000" +
      "\001B-\n\024grpc.employeeServiceB\023EmployeeServi" +
      "ceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_employeeService_AddEmployeeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_employeeService_AddEmployeeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employeeService_AddEmployeeRequest_descriptor,
        new java.lang.String[] { "EmployeeNumber", "EmployeeName", "Position", "Salary", });
    internal_static_employeeService_AddEmployeeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_employeeService_AddEmployeeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employeeService_AddEmployeeResponse_descriptor,
        new java.lang.String[] { "Success", });
    internal_static_employeeService_GetEmployeeRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_employeeService_GetEmployeeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employeeService_GetEmployeeRequest_descriptor,
        new java.lang.String[] { "EmployeeNumber", });
    internal_static_employeeService_GetEmployeeResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_employeeService_GetEmployeeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employeeService_GetEmployeeResponse_descriptor,
        new java.lang.String[] { "EmployeeDetails", });
    internal_static_employeeService_GetAllEmployeesRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_employeeService_GetAllEmployeesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_employeeService_GetAllEmployeesRequest_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
