import java.lang.Math;

class Solution {
    public int maxProfit(int[] prices) {
        // N : len(prices)
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = prices.length;
        // int maxProfit = 0;
        // for (int i=0; i<n; i++){
        //     for (int j=i+1; j<n; j++){
        //         maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        //     }
        // }
        // return maxProfit;


        // N : len(prices)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = prices.length;
        int l = 0;
        int r = 0;
        int maxProfit = 0;
        while (r < n){
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            if (prices[r] < prices[l]){
                l = r;
            }
            r++;
        }
        return maxProfit;
    }
}