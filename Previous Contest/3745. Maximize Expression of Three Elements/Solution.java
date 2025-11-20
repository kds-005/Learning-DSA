import java.lang.Math;

class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N^3)
        // Space Complexity: O(1)
        // int n = nums.length;
        // int maxExp = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             maxExp = Math.max(maxExp, (nums[i] + nums[j] - nums[k]));
        //             maxExp = Math.max(maxExp, (nums[i] + nums[k] - nums[j]));
        //             maxExp = Math.max(maxExp, (nums[k] + nums[j] - nums[i]));
        //         }
        //     }
        // }
        // return maxExp;
        

        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = nums.length;
        int firstBig, secondBig, smallest;
        firstBig = smallest = nums[0];
        secondBig = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            smallest = Math.min(smallest, nums[i]);
            
            if (firstBig < nums[i]) {
                secondBig = firstBig;
                firstBig = nums[i];
            } else if (secondBig < nums[i]) secondBig = nums[i];
        }
        return (firstBig + secondBig - smallest);
    }
}