from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # N : len(nums)
        # Time Complexity: O(N LogN)
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = (r + l) // 2
            if target < nums[mid]:
                r = mid - 1
            elif target > nums[mid]:
                l = mid + 1
            else:
                return mid
        return -1