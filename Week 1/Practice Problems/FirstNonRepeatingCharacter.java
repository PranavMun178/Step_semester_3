public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        // ASCII frequency array
        int[] freq = new int[256];

        // Count occurrences
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Find first char with frequency = 1
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0'; // Return null character if none found
    }

    public static void checkAndPrint(String input) {
        char result = findFirstNonRepeatingChar(input);
        if (result != '\0') {
            System.out.println("Input: \"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("Input: \"" + input + "\" -> No Non-Repeating Character Found");
        }
    }

    public static void main(String[] args) {
        checkAndPrint("swiss");
        checkAndPrint("aabbcc");
    }
}