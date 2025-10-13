from typing import List

class Solution:
    def maxKDistinct(self, nums: List[int], k: int) -> List[int]:
        nums.sort()
        n = len(nums)
        result = [nums[n - 1]]
        for i in range(n - 2, -1, -1):
            if k == 1:
                break
            if result[len(result) - 1] == nums[i]:
                continue
            result.append(nums[i])
            k -= 1
        return result