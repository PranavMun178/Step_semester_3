import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        // Set of stop words to ignore
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // 1. Normalize: convert to lowercase and remove periods/commas
        String cleaned = feedback.toLowerCase()
                                 .replace(".", "")
                                 .replace(",", "");

        // 2. Split into words using whitespace
        String[] words = cleaned.split("\\s+");

        // 3. Count frequencies using a HashMap
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue; // Skip stop words or empty strings
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // 4. Sort entries by frequency in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 5. Print results
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(input);
    }
}