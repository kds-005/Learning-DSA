from typing import List

class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        # N : len(nums)
        # Time Complexity : O(N^2)
        # Space Complexity : O(1)
        n = len(nums)
        subCount = 0
        for i in range(n):
            countTarget = 0
            for j in range(i, n):
                if nums[j] == target:
                    countTarget += 1
                if countTarget > (j - i + 1) // 2:
                    subCount += 1
        return subCount