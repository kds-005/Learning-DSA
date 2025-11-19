import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // N : len(nums)
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[i] + nums[j] == target) return new int[]{i, j};
        //     }   
        // }
        // return new int[]{};


        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = nums.length;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (sumMap.containsKey(nums[i])) return new int[]{i, sumMap.get(nums[i])};
            sumMap.put((target - nums[i]), i);
        }
        return new int[]{};
    }
}