from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Comlpexity: O(N)
        numSet = set()
        for num in nums:
            if num in numSet:
                return True
            numSet.add(num)
        return False