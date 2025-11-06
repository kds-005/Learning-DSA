class Solution {
    public int reverseDegree(String s) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = s.length();
        int reverseDegree = 0;
        for (int i = 0; i < n; i++) {
            reverseDegree += ('z' - s.charAt(i) + 1) * (i + 1);
        }
        return reverseDegree;
    }
}