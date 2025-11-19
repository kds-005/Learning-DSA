from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # N : len(nums)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(nums)
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         if nums[i] + nums[j] == target:
        #             return [i, j]
        # return[-1, -1]

        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(nums)
        sumMap = {}
        for i in range(n):
            sumMap[nums[i]] = i
        
        for i in range(n):
            diff = (target - nums[i])
            if diff in sumMap and sumMap[diff] != i:
                return [i, sumMap[diff]]
        return [-1, -1]