package grpc.orderService;

import grpc.stockService.ProductRequest;
import grpc.stockService.ProductResponse;
import grpc.stockService.StockServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import warehouse.Order;
import warehouse.Product;
import warehouse.Stock;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class OrderServer extends OrderServiceGrpc.OrderServiceImplBase {
    private static ArrayList<Order> orders;
    private static Stock stock;
    private static StockServiceGrpc.StockServiceStub stockServiceAsyncStub = null;

    public static void main(String[] args) throws FileNotFoundException {
        // load stock data with all products
        stock = new Stock();
        loadStockData();
        //System.out.println(stock.getProduct(1001));
        // load orders data
        orders = new ArrayList<>();
        loadOrdersData();
        //System.out.println(orders.get(0));

        // start server
        OrderServer orderServer = new OrderServer();
        Properties prop = orderServer.getProperties();
        orderServer.registerService(prop);
        int port = Integer.parseInt(prop.getProperty("service_port"));

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(orderServer)
                    .build()
                    .start();

            System.out.println("Order Server started, listening on " + port);

            server.awaitTermination();


        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Properties getProperties() {
        Properties prop = null;

        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/order.properties"))) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Order Service properties ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " + prop.getProperty("service_name"));
            System.out.println("\t service_description: " + prop.getProperty("service_description"));
            System.out.println("\t service_port: " + prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    private void registerService(Properties prop) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type");
            String service_name = prop.getProperty("service_name");
            // int service_port = 1234;
            int service_port = Integer.parseInt(prop.getProperty("service_port"));


            String service_description_properties = prop.getProperty("service_description");

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            System.out.printf("Registering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void loadStockData() throws FileNotFoundException {
        File directory = new File(".//Files");
        String stockFile = directory.getAbsolutePath() + "//Stock.csv";
        Scanner sc = new Scanner(new File(stockFile));

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0; String st;

        while (sc.hasNextLine())  //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            stock.addProduct(new Product(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Integer.parseInt(data[3])));
        }
    }

    private static void loadOrdersData() throws FileNotFoundException {
        File directory = new File(".//Files");
        String ordersFile = directory.getAbsolutePath() + "//Orders.csv";
        Scanner sc = new Scanner(new File(ordersFile));

        // this will just print the header in CSV file
        sc.nextLine();

        Order order = null;

        while (sc.hasNextLine())  //returns a boolean value
        {
            String st = sc.nextLine();
            String[] data = st.split(",");
            // get order details
            int orderNumber = Integer.parseInt(data[0]);
            String orderDate = data[1];
            int orderedQty = Integer.parseInt(data[3]);
            Order thisOrder = new Order(orderNumber, orderDate);
            // get product details
            int productNum = Integer.parseInt(data[2]);
            String productDescription = stock.getProduct(productNum).getDescription();
            float price = stock.getProduct(productNum).getPrice();
            int stockQty = stock.getProduct(productNum).getQuantity();
            Product product = new Product(productNum, productDescription, price, stockQty);
            // check if order already exists
            //System.out.println("prev order: " + order + ", new order: " + thisOrder);
            if (order == null || thisOrder.compareTo(order) != 0) {
                order = thisOrder;
                //System.out.println("adding a new order");
                orders.add(order);
                order.addItem(product, orderedQty);
            } else {
                //System.out.println("adding to same order");
                order.addItem(product, orderedQty);
            }
        }

        sc.close();  //closes the scanner
    }

    // implement get total sales method to print the total of all orders
    public void getTotalSales(TotalSalesRequest request, StreamObserver<TotalSalesResponse> responseObserver) {
        System.out.println("Receiving total sales request...");
        float totalSales = 0;
        for (Order order : orders) {
            totalSales += order.getTotalValue();
        }
        //System.out.println("Total Order: " + totalSales);
        TotalSalesResponse response = TotalSalesResponse.newBuilder().setSalesTotal(totalSales).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void getOrderDetails(GetOrderRequest request, StreamObserver<GetOrderResponse> responseObserver) {
        int num = request.getOrderNumber();
        if (num == -1) {
            System.out.println("Received a request to list all orders");
            for (Order order : orders) {
                GetOrderResponse response = GetOrderResponse.newBuilder().setOrderDetails(order.toString()).build();
                responseObserver.onNext(response);
            }
        } else if (num > 0) {
            System.out.println("Received a request for product " + num);
            Order found = null;
            for (Order order : orders) {
                if (order.getOrderNumber() == num) {
                    found = order;
                    GetOrderResponse response = GetOrderResponse.newBuilder().setOrderDetails(found.toString()).build();
                    responseObserver.onNext(response);
                    return;
                }
            }
            // if order not found
            GetOrderResponse response = GetOrderResponse.newBuilder().setOrderDetails("Order not found!").build();
            responseObserver.onNext(response);
        } else {
            System.out.println("Received a request for invalid order " + num);
            GetOrderResponse response = GetOrderResponse.newBuilder().setOrderDetails("Order not found!").build();
            responseObserver.onNext(response);
        }

        try {
            //wait for a second
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        responseObserver.onCompleted();
    }

    public void cancelOrder(CancelOrderRequest request, StreamObserver<CancelOrderResponse> responseObserver) {
        int num = request.getOrderNumber();
        if (num == -1) {
            System.out.println("Missing order number!");
            CancelOrderResponse response = CancelOrderResponse.newBuilder().setSuccess(false).build();
            responseObserver.onNext(response);
        } else if (num > 0) {
            System.out.println("Received a request to cancel order " + num);
            Order found = null;
            for (Order order : orders) {
                if (order.getOrderNumber() == num) {
                    orders.remove(order);
                    CancelOrderResponse response = CancelOrderResponse.newBuilder().setSuccess(true).build();
                    responseObserver.onNext(response);
                    break;
                }
            }
        } else {
            System.out.println("Received a cancel request for an invalid order " + num);
            CancelOrderResponse response = CancelOrderResponse.newBuilder().setSuccess(false).build();
            responseObserver.onNext(response);
        }

        try {
            //wait for a second
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        responseObserver.onCompleted();
    }

    public StreamObserver<PlaceOrderRequest> placeOrder (StreamObserver<PlaceOrderResponse> responseObserver){
        int orderNumber = orders.get(orders.size() - 1).getOrderNumber() + 1;
        // add a new order with order number alst + 1, and simple date dd/mm/yyyy
        Order order = new Order(orderNumber, new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        return new StreamObserver<PlaceOrderRequest>() {
            public void onNext(PlaceOrderRequest request) {
                int productNum = request.getStockNumber();
                int qtyToOrder = request.getQuantity();
                /*****/
                ProductRequest productRequest = ProductRequest.newBuilder().setStockNumber(productNum).build();
                StreamObserver<ProductResponse> productResponse = new StreamObserver<ProductResponse>() {
                    @Override
                    public void onNext(ProductResponse productResponse) {
                        Product product = new Product(productResponse.getStockNumber(), productResponse.getDescription(), productResponse.getPrice(), productResponse.getQty());
                        order.addItem(product, qtyToOrder);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onCompleted() {}

                };
                stockServiceAsyncStub.getProduct(productRequest, productResponse);
                /****/
            }

            public void onCompleted() {
                PlaceOrderResponse response = PlaceOrderResponse.newBuilder().setOrderNumber(orderNumber).build();
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }
        };

    }

}