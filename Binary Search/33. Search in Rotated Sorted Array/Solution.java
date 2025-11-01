class Solution {
    public int search(int[] nums, int target) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == target) return i;
        // }
        // return -1;


        // N : len(nums)
        // Time Complexity: O(logN)
        // Space Complexity: O(1)
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target <= nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}