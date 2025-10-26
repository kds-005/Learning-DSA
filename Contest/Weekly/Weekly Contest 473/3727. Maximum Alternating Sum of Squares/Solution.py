from typing import List

class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n = len(nums)
        nums = [num * num for num in nums]
        nums.sort()
        res = sum(nums[n//2:]) - sum(nums[:n//2])
        return res