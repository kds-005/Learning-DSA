class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for (int r=1; r<n; r++){
            if(prices[r - 1] < prices[r]){
                profit += (prices[r] - prices[r - 1]);
            }
        }
        return profit;
    }
}