from typing import List

# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':
        # N : no of rows and columns
        # Time Complexity: O(N * N * logN)
        # Space Complexity: O(logN)
        n = len(grid)
        def isSame(n, r, c):
            for i in range(n):
                for j in range(n):
                    if grid[r][c] == grid[r + i][c + j]:
                        continue
                    return False
            return True

        def dfs(n, r, c):
            if isSame(n, r, c):
                return Node(grid[r][c], True)

            n //= 2
            topLeft = dfs(n, r, c)
            topRight = dfs(n, r, c + n)
            bottomLeft = dfs(n, r + n, c)
            bottomRight = dfs(n, r + n, c + n)
            return Node(0, False, topLeft, topRight, bottomLeft, bottomRight)
        return dfs(n, 0, 0)