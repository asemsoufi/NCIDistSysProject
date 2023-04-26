package grpc.orderService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class OrderServer extends OrderServiceGrpc.OrderServiceImplBase {
    public static void main(String[] args) {
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
}