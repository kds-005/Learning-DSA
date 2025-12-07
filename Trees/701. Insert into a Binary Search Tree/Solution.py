from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        # N : no of node in the Tree
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # if not root:
        #     return TreeNode(val)

        # def dfs(root):
        #     if not root:
        #         return
            
        #     if root.val < val and not root.right:
        #         root.right = TreeNode(val)
        #     elif root.val > val and not root.left:
        #         root.left = TreeNode(val)
        #     elif root.val < val:
        #         dfs(root.right)
        #     elif root.val > val:
        #         dfs(root.left)
            
        # dfs(root)
        # return root


        # N : no of node in the Tree
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not root:
            return TreeNode(val)

        stack = deque([root])
        while stack:
            node = stack.pop()
            if node.val < val and not node.right:
                node.right = TreeNode(val)
                return root
            elif node.val > val and not node.left:
                node.left = TreeNode(val)
                return root
            elif node.val < val:
                stack.append(node.right)
            elif node.val > val:
                stack.append(node.left)
        return root