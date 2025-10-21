from typing import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        # Time Complexity: O(1)
        # Space Complexity: O(1)
        return sum(nums) % k