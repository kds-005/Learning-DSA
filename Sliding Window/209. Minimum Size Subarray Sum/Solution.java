import java.lang.Integer;
import java.lang.Math;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = nums.length;
        // int minLen = Integer.MAX_VALUE;
        // for (int i=0; i<n; i++){
        //     int currSum = 0;
        //     for (int j=i; j<n; j++){
        //         currSum += nums[j];
        //         if (currSum >= target){
        //             minLen = Math.min(minLen, (j - i + 1));
        //             break;
        //         }
        //     }
        // }
        // return minLen == Integer.MAX_VALUE ? 0 : minLen;

        
        // N : len(nums)
        // Time Complexity: O(2N)
        // Space Complexity: O(1)
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int l = 0;
        int r = 0;
        while (r < n){
            currSum += nums[r];
            while (currSum >= target){
                minLen = Math.min(minLen, (r - l + 1));
                currSum -= nums[l];
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}