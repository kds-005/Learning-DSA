from typing import List

class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        maxx = max(nums)
        nums = set(nums)
        for i in range(k, maxx + k + 1):
            if i % k == 0 and i not in nums:
                return i