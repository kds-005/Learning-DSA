import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int currSum = 0;
        HashMap<Integer, Integer> pre = new HashMap<>();
        pre.put(0, 1);
        
        for (int num: nums){
            currSum += num;
            total += pre.getOrDefault(currSum - k, 0);
            pre.put(currSum, pre.getOrDefault(currSum, 0) + 1);
        }
        return total;
    }
}