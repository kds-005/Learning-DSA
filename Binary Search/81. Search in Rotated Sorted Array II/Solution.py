from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        # n = len(nums)
        # for i in range(n):
        #     if nums[i] == target:
        #         return True
        # return False


        # N : len(nums)
        # Time Complexity: O(logN) - best, O(N) - worst
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 0, n - 1
        while l <= r:
            mid = (r + l) // 2
            if nums[mid] == target:
                return True
            if nums[l] < nums[mid]:
                if nums[l] <= target <= nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            elif nums[l] > nums[mid]:
                if nums[mid] <= target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                l += 1
        return False