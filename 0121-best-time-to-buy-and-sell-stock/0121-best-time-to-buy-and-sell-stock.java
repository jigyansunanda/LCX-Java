class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minCostToBuySoFar = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - minCostToBuySoFar);
            minCostToBuySoFar = Math.min(minCostToBuySoFar, prices[i]);
        }
        return maxProfit;
    }
}