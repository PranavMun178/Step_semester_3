public class TypingChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPos = -1; // -1 means no mismatch found yet

        int totalChars = original.length();

        // Loop through each character position
        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matched++;
            } else if (firstMismatchPos == -1) {
                // Record position of the first mismatch (1-based index)
                firstMismatchPos = i + 1; 
            }
        }

        // Calculate accuracy percentage
        double accuracy = ((double) matched / totalChars) * 100;

        // Print output formatted according to requirement
        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n", 
                              matched, totalChars, accuracy);
        } else {
            char origChar = original.charAt(firstMismatchPos - 1);
            char typedChar = typed.charAt(firstMismatchPos - 1);
            
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n", 
                              matched, totalChars, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        checkTypingAccuracy("hello world", "hello worlt");
        // Output: Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')

        // Test Case 2
        checkTypingAccuracy("coding", "coding");
        // Output: Matched: 6/6 | Accuracy: 100.00% | No Mismatches
    }
}