class Solution {
    private int dfs(int total, int[] nums, int[] dp){
        if (total == 0){
            return 1;
        }
        if (total < 0){
            return 0;
        }
        if (dp[total] != -1){
            return dp[total];
        }

        int count = 0;
        for (int num: nums){
            if (total < num) continue;
            count += dfs(total - num, nums, dp);
        }
        dp[total] = count;
        return dp[total];
    }
    public int combinationSum4(int[] nums, int target) {
        // int[] dp = new int[target + 1];
        // Arrays.fill(dp, -1);
        // return dfs(target, nums, dp);

        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int total=1; total<(target + 1); total++){
            int count = 0;
            for (int num: nums){
                if (total < num) continue;
                count += dp[total - num];
            }
            dp[total] = count;
        }
        return dp[target];
    }
}