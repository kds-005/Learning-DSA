class Solution {
    private int digitSum(int num){
        int summ = 0;
        while (num != 0){
            summ += num % 10;
            num /= 10;
        }
        return summ;
    }
    public int smallestIndex(int[] nums) {
        // N : len(nums), M : Max len of digit of nums[i]
        // Time Complexity: O(N * M)
        // Space Complexity: O(1)
        int n = nums.length;
        for (int i=0; i<n; i++){
            if (i == digitSum(nums[i])) return i;
        }
        return -1;
    }
}