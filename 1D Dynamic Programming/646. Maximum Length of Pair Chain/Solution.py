from typing import List

class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        # N: len(pairs)
        # Time Complexity: O(N LogN + N^2)
        # Space Complexity: O(2N) (with recursion stack)
        # n = len(pairs)
        # pairs.sort(key = lambda x: x[0])
        # dp = [-1] * (n + 1)
        # def dfs(idx):
        #     if idx >= n:
        #         return 1
        #     if dp[idx] != -1:
        #         return dp[idx]
        #     res = 0
        #     for i in range(idx + 1, n):
        #         if pairs[idx][1] < pairs[i][0] or idx == -1:
        #             res = max(1 + dfs(i), res)
        #     dp[idx] = res
        #     return dp[idx]
        # return dfs(-1)


        # N: len(pairs)
        # Time Complexity: O(N LogN + N^2)
        # Space Complexity: O(N) (no recursion stack)
        # n = len(pairs)
        # pairs.sort(key = lambda x: x[0])
        # dp = [0] * (n + 1)
        
        # for idx in range(n, -2, -1):
        #     if idx >= n:
        #         dp[idx] = 1
        #     res = 0
        #     for i in range(idx + 1, n):
        #         if pairs[idx][1] < pairs[i][0] or idx == -1:
        #             res = max(1 + dp[i], res)
        #     dp[idx] = res
        # return dp[-1]

        # N: len(pairs)
        # Time Complexity: O(N LogN + N)
        # Space Complexity: O(1)
        n = len(pairs)
        pairs.sort(key = lambda x: x[1])
        longestChain = 1
        prev = pairs[0]
        for i in range(1, n):
            if pairs[i][0] > prev[1]:
                longestChain += 1
                prev = pairs[i]
        return longestChain