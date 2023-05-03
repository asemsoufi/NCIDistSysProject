package grpc.stockService;

import grpc.employeeService.AddEmployeeResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import warehouse.Employee;
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
import java.util.Properties;
import java.util.Scanner;

public class StockServer extends StockServiceGrpc.StockServiceImplBase {
    private static Stock stock;
    public static void main(String[] args) throws FileNotFoundException {
        // load stock data with all products
        stock = new Stock();
        loadStockData();
        //System.out.println(stock.getProduct(1001));

        // start server
        StockServer stockServer = new StockServer();
        Properties prop = stockServer.getProperties();
        stockServer.registerService(prop);
        int port = Integer.parseInt(prop.getProperty("service_port"));

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(stockServer)
                    .build()
                    .start();

            System.out.println("Stock Server started, listening on " + port);

            server.awaitTermination();


        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Properties getProperties() {
        Properties prop = null;

        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/stock.properties"))) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Stock Service properties ...");
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

            String service_type = prop.getProperty("service_type");//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name");// "example";
            // int service_port = 1234;
            int service_port = Integer.parseInt(prop.getProperty("service_port"));// #.50051;


            String service_description_properties = prop.getProperty("service_description");//"path=index.html";

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

        String st;

        while (sc.hasNextLine())  //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            stock.addProduct(new Product(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]), Integer.parseInt(data[3])));
        }
    }

    public void getProduct(ProductRequest request,
                           StreamObserver<ProductResponse> responseObserver) {
        //System.out.println("Receiving a Product request.");
        int num = request.getStockNumber();
        if (num == -1) {
            System.out.println("Processing a request to list all products. Streaming replies...\n");
            for (Product product : stock.getProducts()) {
                ProductResponse response = ProductResponse.newBuilder().setStockNumber(product.getStockNumber())
                        .setDescription(product.getDescription()).setPrice(product.getPrice()).
                        setQty(product.getQuantity()).build();
                responseObserver.onNext(response);
            }
        } else if (num >= 1001 && num <= stock.getProducts().get(stock.getProducts().size() - 1).getStockNumber()) {
            System.out.println("Processing a request to look for product no. " + num);
            Product found = null;
            for (Product product : stock.getProducts()) {
                if (product.getStockNumber() == num) {
                    found = product;
                    System.out.println("Sending a 'Product Found' response to the client.");
                    ProductResponse response = ProductResponse.newBuilder().setStockNumber(found.getStockNumber())
                            .setDescription(found.getDescription()).setPrice(found.getPrice()).
                            setQty(found.getQuantity()).build();
                    responseObserver.onNext(response);
                    break;
                }
            }
        } else {
            System.out.println("Processing a request for an invalid product " + num + "!");
            ProductResponse response = ProductResponse.newBuilder().setStockNumber(-1)
                    .setDescription("Product not found!").setPrice(-1).
                    setQty(-1).build();
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

    public void addProduct(AddProductRequest request, StreamObserver<AddProductResponse> responseObserver) {
        System.out.println("Processing a request to add a new product.");
        int num = -1;
        String description = null;
        float price = -1;
        int qty = -1;
        String message = null;
        boolean result = false;
        AddProductResponse response = null;

        try {
            num = request.getStockNumber();
            if (num < stock.getProducts().get(0).getStockNumber()) {
                message = "Error! Invalid input!";
                System.out.println("Sending an 'Invalid Product Number' response!");
                response = AddProductResponse.newBuilder().setSuccess(result).setMessage(message).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
            description = request.getDescription();
            price = request.getPrice();
            qty = request.getQty();
        } catch (Exception e) {
            message = "Error! Invalid input!";
        }

        for (Product product : stock.getProducts()) {
            if (product.getStockNumber() == num) {
                message = "Error! Product number already exists!";
                System.out.println("Sending an 'product Number already exists' response!");
                response = AddProductResponse.newBuilder().setSuccess(result).setMessage(message).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
        }

        Product product = new Product(num, description, price, qty);
        stock.addProduct(product);
        result = true;
        message = product.getDescription() + " added successfully!";
        System.out.println("Sending a 'Product Successfully Added' response.");
        response = AddProductResponse.newBuilder().setSuccess(result).setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public StreamObserver<UpdateQtyRequest> updateQty (StreamObserver<UpdateQtyResponse> responseObserver){
        System.out.println("\nProcessing a request to update stock quantities.\n");
        return new StreamObserver<UpdateQtyRequest>() {
            public void onNext(UpdateQtyRequest request) {
                System.out.println("Updating qty for product no. " + request.getStockNumber());
                int stockNumber = request.getStockNumber();
                int qty = request.getQty();
                // look for product and update quantity as needed
                for (Product product : stock.getProducts()) {
                    if (product.getStockNumber() == stockNumber) {
                        if (product.getQuantity() >= qty) {
                            product.quantity -= qty;
                            // send reply with the update
                            System.out.println("Sending 'Success' reply with new qty in stock.");
                            UpdateQtyResponse reply = UpdateQtyResponse.newBuilder().setSuccess(true).setMessage("Qty updated! " + product).build();
                            responseObserver.onNext(reply);
                        } else {
                            System.out.println("Sending 'Not enough stock' reply. Qty unchanged.");
                            UpdateQtyResponse reply = UpdateQtyResponse.newBuilder().setSuccess(false).setMessage("Not enough stock!").build();
                            responseObserver.onNext(reply);
                        }
                        return;
                    }
                }
                System.out.println("Sending 'No such product in stock' reply.");
                UpdateQtyResponse reply = UpdateQtyResponse.newBuilder().setSuccess(false).setMessage("No such product in stock!").build();
                responseObserver.onNext(reply);
            }

            public void onCompleted() {
                System.out.println("Done updating stock. Response complete.\n");
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }
        };

    }
}
