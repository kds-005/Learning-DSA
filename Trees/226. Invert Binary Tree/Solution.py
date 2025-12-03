from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # N : no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # def dfs(root):
        #     if not root:
        #         return 
            
        #     root.left, root.right = root.right, root.left
        #     dfs(root.left)
        #     dfs(root.right)
        #     return root
        # return dfs(root)


        # N : no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # stack = deque()
        # stack.append(root)
        # while stack:
        #     node = stack.pop()
        #     if not node:
        #         continue
        #     node.left, node.right = node.right, node.left
        #     stack.append(node.right)
        #     stack.append(node.left)
        # return root


        # N : no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not root:
            return root
        q = deque([root])
        while q:
            n = len(q)
            for _ in range(n):
                node = q.popleft()
                node.left, node.right = node.right, node.left
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return root