class Solution {
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private long calculateCost(long logLen, long maxLoad) {
        long minCost = 0;
        if (logLen > maxLoad) minCost = (logLen - maxLoad) * maxLoad;
        return minCost;
    }
    public long minCuttingCost(int n, int m, int k) {
        return calculateCost(m, k) + calculateCost(n, k);
    }
}