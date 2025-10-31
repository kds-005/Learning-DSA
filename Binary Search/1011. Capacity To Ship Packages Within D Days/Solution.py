from typing import List

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        # N : len(weights), M : sum(weights) - max(weights)
        # Time Complexity: O(M * N)
        # Space Complexity: O(1)
        # n = len(weights)
        # m = max(weights)
        # s = sum(weights) + 1
        # minWeight = float('inf')
        # for i in range(m, s):
        #     dayCount = 0
        #     flag = True
        #     summ = 0
        #     for weight in weights:
        #         summ += weight
        #         if summ > i:
        #             summ = weight
        #             dayCount += 1
        #         if dayCount >= days:
        #             flag = False
        #             break
        #     if flag:
        #         return i
        # return 0



        # N : len(weights), M : sum(weights) - max(weights)
        # Time Complexity: O(N * logM)
        # Space Complexity: O(1)
        l = max(weights)
        r = sum(weights) + 1
        while l <= r:
            mid = (r + l) // 2
            dayCount = 1
            summ = 0
            for weight in weights:
                summ += weight
                if summ > mid:
                    summ = weight
                    dayCount += 1
            if dayCount <= days:
                r = mid - 1
            else:
                l = mid + 1
        return l