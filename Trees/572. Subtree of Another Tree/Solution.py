from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        # N : no of node in root, M : no of nodes in subRoot
        # Time Complexity: O(N * M)
        # Space Complexity: O(N + M)

        def isSameTree(root, subRoot):
            if not root and not subRoot:
                return True
            
            if (not root or not subRoot or root.val != subRoot.val):
                return False

            left = isSameTree(root.left, subRoot.left)
            right = isSameTree(root.right, subRoot.right)

            return left and right
        
        def dfs(root):
            if not root:
                return False
            
            if isSameTree(root, subRoot) or not subRoot:
                return True
            
            left = dfs(root.left)
            right = dfs(root.right)

            return left or right
        return dfs(root)