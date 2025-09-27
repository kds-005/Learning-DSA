from typing import List

class Solution:
    def climbStairs(self, n: int, costs: List[int]) -> int:
        dp = {}
        def dfs(idx):
            if idx == n:
                return 0
            if idx > n:
                return float('inf')
            if idx in dp:
                return dp[idx]

            step1 = step2 = step3 = float('inf')
            if idx + 1 <= n:
                step1 = dfs(idx + 1) + costs[idx] + 1
            if idx + 2 <= n:
                step2 = dfs(idx + 2) + costs[idx + 1] + 4
            if idx + 3 <= n:
                step3 = dfs(idx + 3) + costs[idx + 2] + 9
            dp[idx] = min(step1, step2, step3)
            return dp[idx]
        return dfs(0)