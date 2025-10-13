from typing import List

class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        n = len(nums)
        res = 0
        for i in range(n):
            res ^= nums[i]

        if res != 0:
            return n
        else:
            return n - 1 if sum(nums) != 0 else 0