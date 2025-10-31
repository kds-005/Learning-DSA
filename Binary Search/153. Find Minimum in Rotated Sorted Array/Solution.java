import java.lang.Math;

class Solution {
    public int findMin(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        // int minNum = Integer.MAX_VALUE;
        // for (int num: nums) minNum = Math.min(minNum, num);
        // return minNum;


        // N : len(nums)
        // Time Complexity: O(logN)
        // Space Complexity: O(1)
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[l] > nums[r]) {
                if (nums[l] <= nums[mid]) l = mid + 1;
                else r = mid;
            } else return nums[l];
        }
        return nums[l];
    }
}