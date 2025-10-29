import java.lang.Math;

class Solution {
    public int[] minCosts(int[] costs) {
        // N : len(cost)
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> with the output arr
        int n = costs.length;
        int[] minCostArr = new int[n];
        for (int i = 0; i < n; i++) {
            minCostArr[i] = (i != 0) ? Math.min(minCostArr[i - 1], costs[i]) : costs[i];
        }
        return minCostArr;
    }
}