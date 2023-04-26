package warehouse; /**
 * @author Mohammad Asem Soufi, based on code from class
 * the original algorithm only returns true/false as a search result, but here I tweek it to return a list of any matching Product objects
 * Student: x18191665
 */

import java.util.ArrayList;

class StockBinarySearch {

    private final ArrayList<Product> results = new ArrayList<>();  // an ArrayList to hold search matches, if any


    /**
     * a method to search stock for products with a specific size and return all matching products sorted based on their stock number
     * @param products our stock array of products
     * @param targetSize the size we are looking for
     * @param low starting point of our search
     * @param high ending point of our search
     * @return an ArrayList of results/matching products with the size we were searching for
     */
    public ArrayList<Product> search(Product[] products, float targetSize, int low, int high) {
        if (low > high) {
            return results;
        } else {
            // our stock array is sorted, so divide and conquer
            int mid = low + (high - low) / 2;
            // if a match is found, add it to our search results ArrayList
            if (targetSize == products[mid].getPrice()) {
                results.add(products[mid]);
                // check for neighboring matches. i.e. there could be more matches before and/or after current match
                // traverse stock array backward for possible matches Before current match
                int i = mid - 1;
                while (i >= 0 && targetSize == products[i].getPrice()) {
                    // add product in correct ascending order based on stock number to produce a sorted list of results
                    results.add(0, products[i]);
                    i--;
                }
                // traverse stock array forward for possible matches After current match
                int j = mid + 1;
                while (j < products.length && targetSize == products[j].getPrice()) {
                    // add product at the end of results list to produce a sorted list of results
                    results.add(products[j]);
                    j++;
                }
            // if not a match, search again
            } else if (targetSize < products[mid].getPrice()) {
                return search(products, targetSize, low, mid - 1);
            } else {
                return search(products, targetSize, mid + 1, high);
            }
        }

        return results;
    }
}