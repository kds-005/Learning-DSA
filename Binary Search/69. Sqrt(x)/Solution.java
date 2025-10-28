class Solution {
    public int mySqrt(int x) {
        // N : x
        // Time Complexity: O(logN)
        // Space Complexity: O(1)
        long l = 0;
        long r = x;
        while (l <= r) {
            long mid = (r + l) / 2;
            if (x > mid * mid) l = mid + 1;
            else if (x < mid * mid) r = mid - 1;
            else return (int) mid;
        }
        return (int) l - 1;
    }
}