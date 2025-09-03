from typing import List

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        # dp = [[-1] * (2) for _ in range(n + 1)]
        # def dfs(idx, isBuy):
        #     if idx >= n:
        #         return 0
        #     if dp[idx][isBuy] != -1:
        #         return dp[idx][isBuy]

        #     notTake = dfs(idx + 1, isBuy)

        #     if isBuy == 1:
        #         take = dfs(idx + 1, 0) - prices[idx]
        #     elif isBuy == 0:
        #         take = dfs(idx + 1, 1) + prices[idx] - fee

        #     dp[idx][isBuy] = max(notTake, take)
        #     return dp[idx][isBuy]
        
        # return dfs(0, 1)

        prev = [0] * 2
        for idx in range(n - 1, -1, -1):
            curr = [0] * 2
            for isBuy in range(2):
                if isBuy == 1:
                    notTake = prev[1]
                    take = prev[0] - prices[idx]
                    curr[isBuy] = max(notTake, take)
                else:
                    notTake = prev[0]
                    take = prev[1] + prices[idx] - fee
                    curr[isBuy] = max(notTake, take)
            prev = curr
        return prev[1]