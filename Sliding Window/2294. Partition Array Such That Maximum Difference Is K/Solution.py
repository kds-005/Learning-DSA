from typing import List

class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        # Time Complexity: O(NlogN)
        # Space Complexity: O(1)
        nums.sort()
        n = len(nums)
        l, r = 0, 0
        groups = 1
        while r < n:
            if nums[r] - nums[l] > k:
                groups += 1
                l = r
            r += 1
        return groups