from typing import List

class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        # N : len(nums), M : Max len of digit of nums[i]
        # Time Complexity: O(N * M)
        # Space Complexity: O(1)
        def digitSum(num):
            summ = 0
            while num != 0:
                summ += (num % 10)
                num //= 10
            return summ
        
        n = len(nums)
        for i in range(n):
            if i == digitSum(nums[i]):
                return i
        return -1