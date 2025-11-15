import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Comlpexity: O(N)
        HashSet numSet = new HashSet<>();
        for (int num: nums) {
            if (numSet.contains(num)) return true;
            numSet.add(num);
        }
        return false;
    }
}