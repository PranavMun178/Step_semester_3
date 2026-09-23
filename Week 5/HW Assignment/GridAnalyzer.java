public class GridAnalyzer {

    // Private helper method to calculate average for a single match row
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        
        double sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return sum / row.length;
    }

    // Classifies each match in the 2D grid
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) return "";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        System.out.println(classifyMatches(grid, threshold));
        // Expected: Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}