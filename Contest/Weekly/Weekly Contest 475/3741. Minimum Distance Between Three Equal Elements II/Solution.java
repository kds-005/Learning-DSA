import java.util.*;
import java.lang.Math;

class Solution {
    public int minimumDistance(int[] nums) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = nums.length;
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = freq.getOrDefault(nums[i], new ArrayList<>());
            temp.add(i);
            freq.put(nums[i], temp);
        }

        int minDist = Integer.MAX_VALUE;
        for (int key: freq.keySet()) {
            List<Integer> val = freq.get(key);
            int m = val.size();

            if (m < 3) continue;
            
            int currDist = 0;
            for (int i = 2; i < m; i++) {
                currDist = Math.abs(val.get(i - 2) - val.get(i - 1)) + 
                            Math.abs(val.get(i - 1) - val.get(i)) + 
                            Math.abs(val.get(i) - val.get(i - 2));
                minDist = Math.min(minDist, currDist);
            }
        }
        return (minDist != Integer.MAX_VALUE) ? minDist : -1;
    }
}