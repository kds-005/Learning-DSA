from typing import List

class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        minNum = min(nums)
        maxNum = max(nums)
        res = []
        numSet = set(nums)
        for num in range(minNum, maxNum):
            if num not in numSet:
                res.append(num)
        return res