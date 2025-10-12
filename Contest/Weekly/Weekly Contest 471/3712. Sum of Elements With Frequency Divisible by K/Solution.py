from collections import defaultdict
from typing import List

class Solution:
    def sumDivisibleByK(self, nums: List[int], k: int) -> int:
        freqMap = defaultdict(int)
        for num in nums:
            freqMap[num] += 1

        totalSum = 0
        for num in nums:
            if freqMap[num] % k != 0:
                continue
            totalSum += num
        return totalSum