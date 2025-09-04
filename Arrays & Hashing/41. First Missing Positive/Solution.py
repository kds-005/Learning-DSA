from typing import List

class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # Time Complexity : O(n^2) 
        # Space Complexity: 0(1)
        # maxNum = max(nums)
        # for i in range(1, maxNum + 2):
        #     flag = False
        #     for num in nums:
        #         if num == i:
        #             flag = True
        #             break
        #     if not flag:
        #         return i
        # return 1
        
        # Time Complexity : O(n) 
        # Space Complexity: 0(n)
        # maxNum = max(nums)
        # numSet = set(nums)
        # for i in range(1, maxNum + 2):
        #     if i not in numSet:
        #         return i
        # return 1

        # Time Complexity : O(3n) 
        # Space Complexity: 0(1)
        n = len(nums)
        for i in range(n):
            if nums[i] > 0:
                continue
            nums[i] = n + 2

        for i in range(n):
            if abs(nums[i]) - 1 >= n:
                continue
            nums[abs(nums[i]) - 1] = abs(nums[abs(nums[i]) - 1]) * -1

        for i in range(1, n + 2):
            if i - 1 >= n or nums[i - 1] > 0:
                return i