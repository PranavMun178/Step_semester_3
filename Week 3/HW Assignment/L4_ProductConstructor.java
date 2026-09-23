class Product {
    String productId;
    String productName;

    // Constructor taking both values as parameters
    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}

public class L4_ProductConstructor {
    public static void main(String[] args) {
        // Create a Product object using the constructor
        Product product = new Product("P-1042", "Wireless Mouse");

        // Print both fields on one line
        System.out.println(product.productId + " - " + product.productName);
    }
}