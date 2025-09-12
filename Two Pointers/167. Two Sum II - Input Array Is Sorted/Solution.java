import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Time Complexity: O(2N)
        // Space Complexity: O(N)
        // int n = nums.length;
        // HashMap<Integer, Integer> numsMap = new HashMap<>();
        // for (int i=0; i<n; i++){
        //     numsMap.put(target - nums[i], i);
        // }

        // for (int i=0; i<n; i++){
        //     if (numsMap.containsKey(nums[i])){
        //         return new int[] {i + 1, numsMap.get(nums[i]) + 1};
        //     }
        // }
        // return new int[]{-1, -1};


        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r){
            int summ = nums[l] + nums[r];
            if (summ == target){
                return new int[] {l + 1, r + 1};
            } else if (summ > target){
                r--;
            } else{
                l++;
            }
        }
        return new int[]{-1, -1};
    }
}