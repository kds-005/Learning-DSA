import java.lang.Math;

class Solution {
    private int dfs(int i, int j, int[] nums1, int[] nums2, int[][] dp){
        if (i >= nums1.length || j >= nums2.length) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int res = 0;
        if (nums1[i] == nums2[j]){
            res = 1 + dfs(i + 1, j + 1, nums1, nums2, dp);
        } else{
            res = Math.max(dfs(i + 1, j, nums1, nums2, dp), dfs(i, j + 1, nums1, nums2, dp));
        }
        return dp[i][j] = res;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // N : len(nums1), M : len(nums2)
        // Time Complexity : O(N * M)
        // Space Complexity: O(N * M) + Stack Space
        // int n = nums1.length;
        // int m = nums2.length;
        // int[][] dp = new int[n + 1][m + 1];
        // for (int i=0; i<n+1; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return dfs(0, 0, nums1, nums2, dp);

        // N : len(nums1), M : len(nums2)
        // Time Complexity : O(N * M)
        // Space Complexity: O(N * M)
        // int n = nums1.length;
        // int m = nums2.length;
        // int[][] dp = new int[n + 1][m + 1];
        // for (int i=n; i>=0; i--){
        //     for (int j=m; j>=0; j--){
        //         if (i >= n || j >= m) continue;
                
        //         int res = 0;
        //         if (nums1[i] == nums2[j]){
        //             res = 1 + dp[i + 1][j + 1];
        //         } else{
        //             res = Math.max(dp[i + 1][j], dp[i][j + 1]);
        //         }
        //         dp[i][j] = res;
        //     }
        // }
        // return dp[0][0];

        // N : len(nums1), M : len(nums2)
        // Time Complexity : O(N * M)
        // Space Complexity: O(M)
        int n = nums1.length;
        int m = nums2.length;
        int[] prev = new int[m + 1];
        for (int i=n; i>=0; i--){
            int[] curr = new int[m + 1];
            for (int j=m; j>=0; j--){
                if (i >= n || j >= m) continue;
                
                int res = 0;
                if (nums1[i] == nums2[j]){
                    res = 1 + prev[j + 1];
                } else{
                    res = Math.max(prev[j], curr[j + 1]);
                }
                curr[j] = res;
            }
            prev = curr;
        }
        return prev[0];
    }
}