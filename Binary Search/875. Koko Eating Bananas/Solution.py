import math
from typing import List

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # N : len(piles), M : max(piles)
        # Time Complexity: O(N * M)
        # Space Complexity: O(1)
        # m = max(piles) + 1
        # for banana in range(1, m):
        #     totalHour = 0
        #     for pile in piles:
        #         totalHour += math.ceil(pile / banana)
        #     if totalHour <= h:
        #         return banana
        # return 0


        # N : len(piles), M : max(piles)
        # Time Complexity: O(N * logM)
        # Space Complexity: O(1)
        l, r = 1, max(piles)
        while l <= r:
            mid = (r + l) // 2
            totalHour = 0
            for pile in piles:
                totalHour += math.ceil(pile / mid)
                
            if totalHour > h:
                l = mid + 1
            elif totalHour <= h:
                r = mid - 1
        return l