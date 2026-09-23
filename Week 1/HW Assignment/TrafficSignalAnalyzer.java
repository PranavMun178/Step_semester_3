public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("No readings available.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentStreakColor = signalLog.charAt(0);
        int currentStreak = 1;

        // Loop through the log starting from the second character
        for (int i = 1; i < signalLog.length(); i++) {
            char currentChar = signalLog.charAt(i);

            if (currentChar == currentStreakColor) {
                currentStreak++;
            } else {
                // Color changed, reset current streak tracking
                currentStreakColor = currentChar;
                currentStreak = 1;
            }

            // Update longest streak found so far
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                longestColor = currentStreakColor;
            }
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        // Test Case 1
        findLongestStreak("RRGGGYRR");
        // Output: Longest Streak: 'G' repeated 3 times

        // Test Case 2
        findLongestStreak("RRRRYYGG");
        // Output: Longest Streak: 'R' repeated 4 times
    }
}