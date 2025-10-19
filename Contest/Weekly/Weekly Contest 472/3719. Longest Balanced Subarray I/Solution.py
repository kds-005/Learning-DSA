from typing import List

class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        n = len(nums)
        longestSub = 0

        for i in range(n):
            oddSet = set()
            evenSet = set()
            oddSum = evenSum = 0
            for j in range(i, n):
                if nums[j] % 2 == 0 and nums[j] not in evenSet:
                    evenSum += 1
                    evenSet.add(nums[j])
                elif nums[j] % 2 != 0 and nums[j] not in oddSet:
                        oddSum += 1
                        oddSet.add(nums[j])
                if oddSum == evenSum:
                    longestSub = max(longestSub, (j - i + 1))
            if oddSum == evenSum:
                longestSub = max(longestSub, (j - i + 1))
        return longestSub