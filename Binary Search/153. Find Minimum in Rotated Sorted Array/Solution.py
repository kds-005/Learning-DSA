from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        # minNum = float('inf')
        # for num in nums:
        #     minNum = min(minNum, num)
        # return minNum


        # N : len(nums)
        # Time Complexity: O(logN)
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = (r + l) // 2
            if nums[l] > nums[r]:
                if nums[l] <= nums[mid]:
                    l = mid + 1
                else:
                    r = mid
            else:
                return nums[l]
        return nums[l]