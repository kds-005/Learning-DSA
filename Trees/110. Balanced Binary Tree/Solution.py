from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # N : no of nodes in a tree
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        isBalance = True
        def dfs(root):
            nonlocal isBalance
            if not root:
                return 0
            
            left = dfs(root.left)
            right = dfs(root.right)

            if (abs(left - right) > 1):
                isBalance = False

            return 1 + max(left, right)
        
        dfs(root)
        return isBalance