from typing import List

class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        longestSub = maxLen = 2
        
        for i in range(2, n):
            if nums[i - 2] + nums[i - 1] == nums[i]:
                longestSub += 1
            else:
                longestSub = 2
            maxLen = max(longestSub, maxLen)
        return maxLen