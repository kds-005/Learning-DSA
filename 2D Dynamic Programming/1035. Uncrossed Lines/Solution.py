from typing import List

class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        # N : len(nums1), M : len(nums2)
        # Time Complexity : O(N * M)
        # Space Complexity: O(N * M) + Stack Space
        # n = len(nums1)
        # m = len(nums2)
        # dp = [[-1] * (m + 1) for _ in range(n + 1)]
        # def dfs(i, j):
        #     if i >= n or j >= m:
        #         return 0
        #     if dp[i][j] != -1:
        #         return dp[i][j]

        #     res = 0
        #     if nums1[i] == nums2[j]:
        #         res = 1 + dfs(i + 1, j + 1)
        #     else:
        #         res = max(dfs(i + 1, j), dfs(i, j + 1))
        #     dp[i][j] = res
        #     return dp[i][j]
        # return dfs(0, 0)

        # N : len(nums1), M : len(nums2)
        # Time Complexity : O(N * M)
        # Space Complexity: O(N * M)
        # n = len(nums1)
        # m = len(nums2)
        # dp = [[0] * (m + 1) for _ in range(n + 1)]
        # for i in range(n, -1, -1):
        #     for j in range(m, -1, -1):
        #         if i >= n or j >= m:
        #             continue
        #         res = 0
        #         if nums1[i] == nums2[j]:
        #             res = 1 + dp[i + 1][j + 1]
        #         else:
        #             res = max(dp[i + 1][j], dp[i][j + 1])
        #         dp[i][j] = res
        # return dp[0][0]


        # N : len(nums1), M : len(nums2)
        # Time Complexity : O(N * M)
        # Space Complexity: O(M)
        n = len(nums1)
        m = len(nums2)
        prev = [0] * (m + 1)
        for i in range(n, -1, -1):
            curr = [0] * (m + 1)
            for j in range(m, -1, -1):
                if i >= n or j >= m:
                    continue
                res = 0
                if nums1[i] == nums2[j]:
                    res = 1 + prev[j + 1]
                else:
                    res = max(prev[j], curr[j + 1])
                curr[j] = res
            prev = curr
        return prev[0]