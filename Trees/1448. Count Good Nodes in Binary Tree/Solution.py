# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        # N : no of nodes in root
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        def dfs(root, val):
            if not root:
                return 0
            
            goodCount = 0
            if root.val >= val:
                goodCount = 1
                val = root.val
            
            left = dfs(root.left, val)
            right = dfs(root.right, val)

            return goodCount + left + right
        return dfs(root, root.val - 1)