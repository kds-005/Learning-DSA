from typing import List

class Solution:
    def minMoves(self, nums: List[int]) -> int:
        # Time Complexity : O(N)
        # Space Complexity : O(1)
        n = len(nums)
        maxNum = max(nums)
        minMove = 0
        for num in nums:
            minMove += maxNum - num
        return minMove