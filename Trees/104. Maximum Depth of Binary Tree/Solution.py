from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # N : no of nodes in the tree
        # Time Complexity: O(N)
        # Space Complexity: (N) -> Stack Space
        # def dfs(root):
        #     if not root:
        #         return 0
            
        #     left = dfs(root.left)
        #     right = dfs(root.right)

        #     return max(left, right) + 1
        # return dfs(root)


        # N : no of nodes in the tree
        # Time Complexity: O(N)
        # Space Complexity: (N)
        # if not root:
        #     return 0
        
        # stack = deque()
        # stack.append([root, 1])
        # depth = 0
        # while stack:
        #     node, height = stack.pop()
        #     depth = max(depth, height)
        #     if node.right:
        #         stack.append([node.right, height + 1])
        #     if node.left:
        #         stack.append([node.left, height + 1])
        # return depth



        # N : no of nodes in the tree
        # Time Complexity: O(N)
        # Space Complexity: (N)
        if not root:
            return 0

        q = deque([root])
        depth = 0
        while q:
            depth += 1
            n = len(q)
            for _ in range(n):
                node = q.popleft()

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return depth