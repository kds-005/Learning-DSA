from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        # n = len(nums)
        # for i in range(n):
        #     if nums[i] == target:
        #         return i
        # return -1
        

        # N : len(nums)
        # Time Complexity: O(logN)
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = (r + l) // 2
            if target == nums[mid]:
                    return mid
            if nums[l] <= nums[mid]:
                if nums[l] <= target <= nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            elif nums[r] >= nums[mid]:
                if nums[mid] <= target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
        return -1