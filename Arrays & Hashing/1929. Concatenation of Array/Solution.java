class Solution {
    public int[] getConcatenation(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(2N)
        int n = nums.length;
        int[] res = new int[n * 2];
        for (int i = 0; i < (n * 2); i++) {
            res[i] = nums[i % n];
        }
        return res;
    }
}