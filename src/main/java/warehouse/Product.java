package warehouse;

/**
 * @author Mohammad Asem Soufi
 * Student: x18191665
 */

public class Product implements Comparable<Object> {
    private final int stockNumber;
    private final String description;
    private final float price;
    private final int quantity;

    public Product(int stockNumber, String description, float price, int qty) {
        this.stockNumber = stockNumber;
        this.description = description;
        this.price = price;
        this.quantity = qty;

        /* an auto calculated attribute to provide a profitability ratio for the sole purpose of Loading Truck task, and is calculated as per the following:
         1- If the Product's Weight > 0, Profitability = Profit / Weight, the higher the ratio the more profitable per weight the product is.
         2- If the Product's Weight is <= 0, the ratio will be based on Size, (i.e. Profitability = Profit / Size).
         3- If Weight AND Size both <= 0. This is either: a wrong entry, or possibly a digital product (in case of 0 weight or size, for example).
            either way, it will be assigned the lowest profitability ratio possible of 0.
         */
    }

    public int getStockNumber() {
        return stockNumber;
    }
    public String getDescription() {return description;
    }
    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "stockNumber: " + stockNumber +
                ", description: '" + description +
                ", price: €" + price +
                ", quantity: " + quantity + '\'' +
                '}';
    }


    /**
     * overriding in a way that compares two products based on profitability,
     * this will be used to determine which products are prioritized to be loaded on the Truck
     * @param o the object (product) to be compared.
     * @return +1 if less profitable, 0 if equally profitable, or -1 if more profitable. This is to guarantee a Descending ordering with the most profitable products at top
     */
    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.stockNumber, ((Product) o).stockNumber);
    }
}
