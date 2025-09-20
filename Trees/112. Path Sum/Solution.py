from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        def dfs(root, summ):
            if root is None:
                return False
            
            if root.left is None and root.right is None and summ + root.val == targetSum:
                return True

            left = dfs(root.left, summ + root.val)
            right = dfs(root.right, summ + root.val)

            return left or right

        return dfs(root, 0)