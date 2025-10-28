class Solution {
    public int search(int[] nums, int target) {
        // N : len(nums)
        // Time Complexity: O(logN)
        // Space Complexity: O(1)
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (target > nums[mid]) l = mid + 1;
            else if (target < nums[mid]) r = mid - 1;
            else return mid;
        }
        return -1;
    }
}