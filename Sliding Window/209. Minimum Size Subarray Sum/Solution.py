from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # N : len(nums)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(nums)
        # minLen = float('inf')
        # for i in range(n):
        #     currSum = 0
        #     for j in range(i, n):
        #         currSum += nums[j]
        #         if currSum >= target:
        #             minLen = min(minLen, (j - i + 1))
        #             break
        # return minLen if minLen != float('inf') else 0


        # N : len(nums)
        # Time Complexity: O(2N)
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 0, 0
        currSum = 0
        minLen = float('inf')
        while r < n:
            currSum += nums[r]
            while currSum >= target:
                minLen = min(minLen, (r - l + 1))
                currSum -= nums[l]
                l += 1
            r += 1
        return minLen if minLen != float('inf') else 0