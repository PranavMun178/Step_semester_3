public class WarehouseBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int highestQty = -1;
        String maxSection = "";
        int maxItemIndex = -1; // 1-based index (e.g., Item 1, Item 2, Item 3)

        // Calculate total for Section A and find highest quantity
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        // Calculate total for Section B and find highest quantity
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        // Check if balanced
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Print final result
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQty, maxSection, maxItemIndex);
    }

    public static void main(String[] args) {
        // Test Case
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
        // Output: Section A Total: 65 | Section B Total: 65 | Status: Balanced | Highest Quantity: 30 (Section A, Item 3)
    }
}