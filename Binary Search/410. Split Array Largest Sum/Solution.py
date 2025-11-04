from typing import List

class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        res = float('inf')
        l, r = max(nums), sum(nums)
        while l <= r:
            mid = (r + l) // 2
            summ = 0
            subCount = 1
            for num in nums:
                summ += num
                if summ > mid:
                    summ = num
                    subCount += 1
            if subCount <= k:
                r = mid - 1
                res = mid
            else:
                l = mid + 1
        return res