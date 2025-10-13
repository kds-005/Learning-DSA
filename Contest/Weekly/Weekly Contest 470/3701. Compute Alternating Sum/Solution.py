from typing import List

class Solution:
    def alternatingSum(self, nums: List[int]) -> int:
        oddSum = evenSum = 0
        for i in range(len(nums)):
            if i % 2 == 0:
                evenSum += nums[i]
            else:
                oddSum += nums[i]
        return evenSum - oddSum