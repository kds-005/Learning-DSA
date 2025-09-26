import java.util.Arrays;
import java.lang.Math;

class Solution {
    private int dfs(int idx, int[] nums, int[] dp){
        if (idx >= nums.length){
            return 0;
        }
        if (dp[idx] != -1){
            return dp[idx];
        }

        int take = dfs(idx + 2, nums, dp) + nums[idx];
        int notTake = dfs(idx + 1, nums, dp);
        return dp[idx] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        // Time Complexity: O(N)
        // Space Complexity: O(N + N)
        // int[] dp = new int[nums.length + 1];
        // Arrays.fill(dp, -1);
        // return dfs(0, nums, dp);

        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // int n = nums.length;
        // int[] dp = new int[n + 2];

        // for (int idx=n-1; idx>=0; idx--){
        //     int take = dp[idx + 2] + nums[idx];
        //     int notTake = dp[idx + 1];
        //     dp[idx] = Math.max(take, notTake);
        // }
        // return dp[0];

        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = nums.length;
        int prev1 = 0;
        int prev2 = 0;
        for (int idx=n-1; idx>=0; idx--){
            int take = prev2 + nums[idx];
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}