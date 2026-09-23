public class InventoryParser {

    public static void parseInventoryRecord(String csvLine) {
        // Split the CSV string by comma
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Trim extra spaces around each value if present
            String product = fields[0].trim();
            String sku = fields[1].trim();
            String qty = fields[2].trim();

            // Print formatted output
            System.out.println("Product: " + product + " | SKU: " + sku + " | Qty: " + qty);
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Valid input
        parseInventoryRecord("Wireless Mouse, WM-2201, 150");

        // Test Case 2: Invalid input (missing SKU)
        parseInventoryRecord("Wireless Mouse, 150");
    }
}