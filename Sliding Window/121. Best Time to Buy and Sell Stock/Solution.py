from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # N : len(prices)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(prices)
        # maxProfit = 0
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         maxProfit = max(maxProfit, prices[j] - prices[i])
        # return maxProfit


        # N : len(prices)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(prices)
        l, r = 0, 0
        maxProfit = 0
        while r < n:
            maxProfit = max(maxProfit, prices[r] - prices[l])
            if prices[r] < prices[l]:
                l = r
            r += 1
        return maxProfit