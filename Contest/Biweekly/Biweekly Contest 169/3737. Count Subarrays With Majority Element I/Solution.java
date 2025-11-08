class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        // N : len(nums)
        // Time Complexity : O(N^2)
        // Space Complexity : O(1)
        int n = nums.length;
        int subCount = 0;
        for(int i = 0; i < n; i++) {
            int targetCount = 0;
            for (int j = i; j < n; j++) {
                if (target == nums[j]) targetCount += 1;
                if (targetCount > (j - i + 1) / 2) subCount += 1;
            }
        }
        return subCount;
    }
}