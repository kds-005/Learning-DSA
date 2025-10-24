import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N^2)
        // Space Complexity: O(N)
        int n = nums.length;
        boolean isSorted = false;
        int count = 0;
        while (!isSorted) {
            int[] minSum = new int[] {Integer.MAX_VALUE, -1};
            isSorted = true;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] + nums[i] < minSum[0]) minSum = new int[] {nums[i - 1] + nums[i], i - 1};
                if (nums[i - 1] > nums[i]) isSorted = false;
            }

            List<Integer> temp = new ArrayList<>();
            if (!isSorted) {
                if (minSum[1] > 0){
                    for (int i = 0; i < minSum[1]; i++) temp.add(nums[i]);
                }
                temp.add(minSum[0]);
                if (minSum[1] < n - 2){
                    for (int i = minSum[1] + 2; i < n; i++) temp.add(nums[i]);
                }
            }
            nums = temp.stream().mapToInt(x -> x).toArray();
            n = nums.length;
            count++;
        }
        return count - 1;
    }
}