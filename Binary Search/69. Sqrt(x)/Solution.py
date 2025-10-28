class Solution:
    def mySqrt(self, x: int) -> int:
        # N : x
        # Time Complexity: O(logN)
        # Space Complexity: O(1)
        n = x
        l, r = 0, n
        while l <= r:
            mid = (r + l) // 2
            if x < mid * mid:
                r = mid - 1
            elif x > mid * mid:
                l = mid + 1
            else:
                return int(mid)
        return int(l) - 1