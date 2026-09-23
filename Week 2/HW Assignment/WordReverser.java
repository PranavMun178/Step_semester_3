public class WordReverser {

    public static String reverseEachWord(String sentence) {
        // Split sentence into words separated by spaces
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Reverse current word using StringBuilder
            StringBuilder temp = new StringBuilder(words[i]);
            String reversedWord = temp.reverse().toString();

            // Append reversed word to result
            result.append(reversedWord);

            // Add space between words (except after the last word)
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "hello club";
        String output = reverseEachWord(input);
        System.out.println(output); // Output: olleh bulc
    }
}