class Solution {
    public boolean search(int[] nums, int target) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == target) return true;
        // }
        // return false;


        // N : len(nums)
        // Time Complexity: O(logN) - best, O(N) - worst
        // Space Complexity: O(1)
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) return true;
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else if (nums[l] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            } else l++;
        }
        return false;
    }
}