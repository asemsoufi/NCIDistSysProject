package warehouse;

/**
 * @author Mohammad Asem Soufi, based on code from class
 * the original algorithm from call sorts Integers, but here I tweek it to handle Product objects
 * Student: x18191665
 */

public class StockMergeSort {

    public static void sizeSort(Product[] products) {
        divide(products, "size");
    }

    /*
    Part 1 - Question 1 - Sorting Algorithm (Merge Sort - Descending), based on Product Size, then on Stock Number respectively
     */

    private static void divide(Product[] products, String sortingColumn) {
        int len = products.length;

        // Create base case.
        if(len <= 1){
            return;
        }

        // Initialise midIndex and left and right arrays
        int midIndex = len / 2;
        Product[] leftHalf = new Product[midIndex];
        Product[] rightHalf = new Product[len - midIndex];

        // populate left array
        for(int i = 0; i < midIndex; i++){
            leftHalf[i] = products[i];
        }
        // populate right array
        for(int i = midIndex; i < len; i++){
            rightHalf[i-midIndex] = products[i];
        }

        // recursively call divide for left array
        divide(leftHalf, sortingColumn);
        // recursively call divide for right array
        divide(rightHalf, sortingColumn);

        // once arrays are divided, we merge.
        merge(products, sortingColumn, leftHalf, rightHalf);
    }

    private static void merge(Product[] products, String sortingColumn, Product[] leftHalf, Product[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // i used to traverse left half
        int i = 0;
        // j used to traverse right half
        int j = 0;
        // k used to traverse products
        int k = 0;

        if (sortingColumn.equals("size")) {     // if sorting is based on product Size
            // loop and add left and right values to products array until full completed left or right array
            while(i < leftSize && j < rightSize){
                if(leftHalf[i].getPrice() < rightHalf[j].getPrice()){
                    products[k] = leftHalf[i];
                    i++;
                } else if(leftHalf[i].getPrice() > rightHalf[j].getPrice()){
                    products[k] = rightHalf[j];
                    j++;
                } else {
                    if(leftHalf[i].getStockNumber() < rightHalf[j].getStockNumber()){
                        products[k] = leftHalf[i];
                        i++;
                    } else {
                        products[k] = rightHalf[j];
                        j++;
                    }
                }
                k++;
            }
        }

        // clean up left array
        while(i < leftSize){
            products[k] = leftHalf[i];
            i++;
            k++;
        }
        // clean up right array
        while (j < rightSize){
            products[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
