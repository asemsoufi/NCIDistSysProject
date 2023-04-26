package warehouse; /**
 * @author Mohammad Asem Soufi
 * Student: x18191665
 */

import java.util.ArrayList;

public class Stock {
    private ArrayList<Product> products; // a Stock has a list of Products

    public Stock() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct (int productNumber) {
        for (Product product : products) {
            if (product.getStockNumber() == productNumber) {
                return product;
            }
        }
        return null;
    }
}
