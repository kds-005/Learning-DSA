from collections import defaultdict
from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Time Complexity: O(2N)
        # Space Complexity: O(N)
        # n = len(nums)
        # numsMap = defaultdict(int)
        # for i in range(n):
        #     numsMap[target - nums[i]] = i
        
        # for i in range(n):
        #     if nums[i] in numsMap:
        #         return [i + 1, numsMap[nums[i]] + 1]
        # return [-1, -1]


        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            summ = nums[l] + nums[r]
            if target == summ:
                return [l + 1, r + 1]
            elif summ > target:
                r -= 1
            else:
                l += 1
        return [-1, -1]