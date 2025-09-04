from collections import defaultdict
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        total = 0
        currSum = 0
        pre = defaultdict(int)  # noqa: F821
        pre[0] = 1

        for num in nums:
            currSum += num
            if currSum - k in pre:
                total += pre[currSum - k]
            pre[currSum] += 1
        return total