from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right



class Solution:
    def removeLeafNodes(self, root: Optional[TreeNode], target: int) -> Optional[TreeNode]:
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        def dfs(root):
            if root is None: return False

            if dfs(root.left): root.left = None
            if dfs(root.right): root.right = None

            return root.left == None and root.right == None and root.val == target
        
        if dfs(root):
            return None
        return root