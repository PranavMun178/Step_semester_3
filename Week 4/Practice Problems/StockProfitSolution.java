public class StockProfitSolution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0]; // Track the lowest price seen so far
        int maxProfit = 0;        // Track the maximum profit seen across the array

        // Single pass through the array
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // Output: 0
    }
}