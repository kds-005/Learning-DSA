import java.util.*;
import java.lang.Math;

class Solution {
    public int maxSum(int[] nums) {
        // N: len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = nums.length;
        int summ = 0;
        int maxVal = Integer.MIN_VALUE;
        boolean zeroFlag = false;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            
            if (nums[i] < 0 || visited.contains(nums[i])) continue;
            if (nums[i] == 0) zeroFlag = true;

            visited.add(nums[i]);
            summ += nums[i];
        }
        return (summ == 0 && zeroFlag == false) ? maxVal : summ;
    }
}