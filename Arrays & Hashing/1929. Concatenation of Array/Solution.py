from typing import List

class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(2N)
        n = len(nums)
        for i in range(n):
            nums.append(nums[i])
        return nums