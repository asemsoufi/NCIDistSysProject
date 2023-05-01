package warehouse;

import java.util.ArrayList;

public class Order implements Comparable<Object> {
    private int orderNumber;
    private String date;
    private ArrayList<OrderItem> items;


    public Order(int orderNumber, String orderDate) {
        this.orderNumber = orderNumber;
        this.date = orderDate;
        this.items = new ArrayList<>();
    }

    public static class OrderItem {
        public Product product;
        public int quantity;
        float value;

        public OrderItem(Product product, int qty) {
            this.product = product;
            this.quantity = qty;
            this.value = product.getPrice() * quantity;
        }
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void addItem(Product product, int qty) {
        for (OrderItem item : items) {
            if (item.product.getStockNumber() == product.getStockNumber()) {
                item.quantity += qty;
                return;
            }
        }
        items.add(new OrderItem(product, qty));
    }


    public float getTotalValue() {
        float total = 0f;
        for (OrderItem item : items) {
            total += item.value;
        }
        return total;
    }

    @Override
    public String toString() {
        String header =  "Order{" +
                "orderNumber=" + orderNumber +
                ", date='" + date + '\'' + "\n";
        StringBuilder sb = new StringBuilder(header);
        if (items.size() == 0) {
            sb.append("Order is empty!");
        } else {
            sb.append("Order details:\n");
            for (OrderItem item : items) {
                Product p = item.product;
                sb.append("    - Product:").append(p.getDescription()).append(", U.Price:€").append(p.getPrice())
                        .append(", Qty:").append(item.quantity).append(", SubTotal:€")
                        .append(String.format("%,.2f", item.value)).append("\n");
            }
            sb.append("Order Grand Total: €").append(String.format("%,.2f",this.getTotalValue())).append("}");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.orderNumber, ((Order) o).getOrderNumber());
    }
}
