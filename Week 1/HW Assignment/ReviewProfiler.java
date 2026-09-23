public class ReviewProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split review string into individual words by whitespace
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;   // 1 to 4 letters
        int mediumCount = 0;  // 5 to 8 letters
        int longCount = 0;    // 9+ letters

        // Check length of each word
        for (String word : words) {
            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        // Print final output format
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        // Test Case
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
        // Output: Short: 3 | Medium: 1 | Long: 3
    }
}