from functools import lru_cache
from typing import List

class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        # M : no of rows of grid, N : no of columns of grid, K : val of k
        # Time Complexity: O(M * N * K)
        # Space Complexity; O(M * N * K)
        m = len(grid)
        n = len(grid[0])
        dp = {}

        @lru_cache(None)
        def dfs(i, j, cost):
            if cost > k:
                return float('-inf')
                
            if i == m - 1 and j == n - 1:
                if grid[i][j] != 0:
                    cost += 1
                if cost <= k:
                    return grid[i][j]
                else:
                    return float('-inf')
                
            if i >= m or i < 0 or j >= n or j < 0:
                return float('-inf')
            # if (i, j, cost) in dp:
            #     return dp[(i, j, cost)]
            
            if grid[i][j] != 0:
                cost += 1
            down = dfs(i + 1, j, cost)
            right = dfs(i, j + 1, cost)
            # dp[(i, j, cost)] = max(down, right) + grid[i][j]
            # return dp[(i, j, cost)]
            return max(down, right) + grid[i][j]
            
        res = dfs(0, 0, 0)
        return res if res != float('-inf') else -1