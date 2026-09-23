import java.util.Arrays;

// Encapsulated Player class implementing Comparable interface
class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    // Sort descending by batting average (fantasy rating)
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftEngine {

    // Rule 1: Established players (matches >= 10) draftable regardless of fitness
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Newer players (matches >= 5) draftable only if NOT injured
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) return "";

        // First pass: Count draftable players
        int draftableCount = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableCount++;
            }
        }

        // Collect draftable players into array
        Player[] draftablePool = new Player[draftableCount];
        int idx = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftablePool[idx++] = p;
            }
        }

        // Sort using standard library via Comparable implementation
        Arrays.sort(draftablePool);

        // Format ranked list output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftablePool.length; i++) {
            sb.append(i + 1).append(". ").append(draftablePool[i].getName());
            if (i < draftablePool.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] lineup = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(lineup));
        // Expected Output: 1. Rahul 2. Virat 3. Dev
    }
}