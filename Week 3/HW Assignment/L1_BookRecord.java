class Book {
    String title;
    double price;
}

public class L1_BookRecord {
    public static void main(String[] args) {
        // Create a Book object
        Book book = new Book();

        // Directly assign values to fields
        book.title = "Clean Code";
        book.price = 650.0;

        // Print output in the required format
        System.out.println("Title: " + book.title + " | Price: Rs " + book.price);
    }
}