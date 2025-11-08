class Solution {
    public int minMoves(int[] nums) {
        // Time Complexity : O(N)
        // Space Complexity : O(1)
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int minMove = 0;
        for (int num: nums) {
            minMove += maxNum - num;
        }
        return minMove;
    }
}