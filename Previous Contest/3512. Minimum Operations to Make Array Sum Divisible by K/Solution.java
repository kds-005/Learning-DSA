import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Time Complexity: O(1)
        // Space Complexity: O(1)
        return Arrays.stream(nums).sum() % k;
    }
}