class Solution {
    private int dfs(int idx, int isBuy, int[] prices, int fee, int[][] dp){
        if (idx >= prices.length){
            return 0;
        }
        if (dp[idx][isBuy] != -1){
            return dp[idx][isBuy];
        }

        int take = Integer.MIN_VALUE;
        int notTake = dfs(idx + 1, isBuy, prices, fee, dp);
        if (isBuy == 1){
            take = dfs(idx + 1, 0, prices, fee, dp) - prices[idx];
        } else {
            take = dfs(idx + 1, 1, prices, fee, dp) + prices[idx] - fee;
        }
        dp[idx][isBuy] = Math.max(take, notTake);
        return dp[idx][isBuy];
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        // int[][] dp = new int[n + 1][2];
        // for (int i=0; i<=n; i++){
        //     for (int j=0; j<2; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // return dfs(0, 1, prices, fee, dp);
        
        int[] prev = new int[2];
        for(int idx = n - 1; idx>=0; idx--){
            int [] curr = new int[2];
            for(int isBuy=0; isBuy<2; isBuy++){
                if (isBuy == 1){
                    int notTake = prev[isBuy];
                    int take = prev[0] - prices[idx];
                    curr[isBuy] = Math.max(take, notTake);
                } else {
                    int notTake = prev[isBuy];
                    int take = prev[1] + prices[idx] - fee;
                    curr[isBuy] = Math.max(take, notTake);
                }
            }
            prev = curr;
        }
        return prev[1];
    }
}