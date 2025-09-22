import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // N : len(nums), K : k
        // Time Complexity: O(N * K)
        // Space Complexity : O(1)
        // int n = nums.length;
        // for (int i=0; i<n; i++)
        //     for (int j=i+1; j<Math.min(n, i+k+1); j++)
        //         if (nums[i] == nums[j]) return true;
        // return false;


        // N : len(nums), K : k
        // Time Complexity: O(N)
        // Space Complexity : O(K)
        int n = nums.length;
        HashSet<Integer> numSet = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < n){
            if (r - l > k){
                numSet.remove(nums[l]);
                l++;
            } else{
                if (numSet.contains(nums[r])) return true;
                numSet.add(nums[r]);
                r++;
            }
        }
        return false;
    }
}