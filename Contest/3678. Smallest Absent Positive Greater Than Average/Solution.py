from typing import List

class Solution:
    def smallestAbsent(self, nums: List[int]) -> int:
        n = len(nums)
        maxx = max(nums)
        avg = int(sum(nums) / n)
        numSet = set(nums)
        for i in range(max(avg + 1, 1), max(n + max(maxx, avg) + 1, 2)):
            if i not in numSet and i > avg:
                return i
        return 1