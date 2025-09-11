class Solution {
    public int partitionArray(int[] nums, int k) {
        // Time Complexity: O(NlogN)
        // Space Complexity: O(1)
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = 0;
        int groups = 1;
        
        while (r < n){
            if (nums[r] - nums[l] > k){
                groups++;
                l = r;
            }
            r++;
        }
        return groups;
    }
}