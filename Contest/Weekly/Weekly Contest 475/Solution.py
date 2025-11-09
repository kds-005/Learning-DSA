from collections import defaultdict
from typing import List

class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(nums)
        freq = defaultdict(list)
        for i in range(n):
            freq[nums[i]].append(i)

        minDist = float('inf')
        for key, val in freq.items():
            if len(val) >= 3:
                for i in range(2, len(val)):
                    dist = abs(val[i - 2] - val[i - 1]) + abs(val[i - 1] - val[i]) + abs(val[i] - val[i - 2])
                    minDist = min(minDist, dist)
        return minDist if minDist != float('inf') else -1