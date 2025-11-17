import java.lang.Math;

class Solution {
    public int findDuplicate(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N logN)
        // Space Complexity: O(1)
        // int n = nums.length;
        // Arrays.sort(nums);
        // for (int i = 1; i < n; i++) {
        //     if (nums[i] == nums[i - 1]) return nums[i];
        // }
        // return -1;


        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // int n = nums.length;
        // int[] freq = new int[n];
        // for (int num: nums) {
        //     if (freq[num] != 0) return num;
        //     freq[num]++;
        // }
        // return -1;


        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) return Math.abs(nums[i]);
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return -1;
    }
}