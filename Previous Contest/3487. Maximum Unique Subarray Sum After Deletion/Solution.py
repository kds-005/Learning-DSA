from typing import List

class Solution:
    def maxSum(self, nums: List[int]) -> int:
        # N: len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(nums)
        visited = set()
        summ = 0
        maxVal = float('-inf')
        zeroFlag = False
        for i in range(n):
            maxVal = max(maxVal, nums[i])

            if nums[i] < 0 or nums[i] in visited:
                continue
            if nums[i] == 0:
                zeroFlag = True

            visited.add(nums[i])
            summ += nums[i]

        return maxVal if (not zeroFlag and summ == 0) else summ