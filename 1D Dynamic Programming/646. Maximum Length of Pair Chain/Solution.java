import java.util.*;

class Solution {
    private int dfs(int idx, int[][]pairs, int[] dp){
        int n = pairs.length;
        if (idx >= n){
            return 1;
        }
        if (dp[idx + 1] != -1){
            return dp[idx + 1];
        }
        int res = 0;
        for (int i=idx+1; i<n; i++){
            if (idx == -1 || pairs[idx][1] < pairs[i][0]){
                res = Math.max(res, 1 + dfs(i, pairs, dp));
            }
        }
        return dp[idx + 1] = res;
    }
    public int findLongestChain(int[][] pairs) {
        // N: len(pairs)
        // Time Complexity: O(N LogN + N^2)
        // Space Complexity: O(2N) (with recursion stack)
        // int n = pairs.length;
        // Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp , -1);
        // return dfs(-1, pairs, dp);


        // N: len(pairs)
        // Time Complexity: O(N LogN + N^2)
        // Space Complexity: O(N) (no recursion stack)
        // int n = pairs.length;
        // Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        // int[] dp = new int[n + 1];
        // for (int idx=n-1; idx>=-1; idx--){
        //     if (idx >= n) dp[idx + 1] = 1;
        //     int res = 0;
        //     for (int i=idx+1; i<n; i++){
        //         if (idx == -1 || pairs[idx][1] < pairs[i][0]){
        //             res = Math.max(res, 1 + dp[i + 1]);
        //         }
        //     }
        //     dp[idx + 1] = res;
        // }
        // return dp[0];


        // N: len(pairs)
        // Time Complexity: O(N LogN + N)
        // Space Complexity: O(1)
        int n = pairs.length;
        Arrays.sort(pairs, (a, b)->Integer.compare(a[1], b[1]));
        int longestPair = 1;
        int[] prev = pairs[0];
        for (int i=1; i<n; i++){
            if (prev[1] < pairs[i][0]){
                longestPair++;
                prev = pairs[i];
            }
        }
        return longestPair;
    }
}