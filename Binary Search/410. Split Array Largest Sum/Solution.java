class Solution {
    public int splitArray(int[] nums, int k) {
        // N : len(nums)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int res = Integer.MAX_VALUE;
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();
        while (l <= r) {
            int mid = (r + l) / 2;
            int subCount = 1;
            int summ = 0;
            for (int num: nums) {
                summ += num;
                if (summ > mid) {
                    summ = num;
                    subCount++;
                }
            }
            if (subCount <= k) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }
}