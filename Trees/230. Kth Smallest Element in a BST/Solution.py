from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # N : no of node in root
        # Time Complexity: O(N)
        # Space Compleixty: O(N) -> Stack Space
        kthVal = 0
        def dfs(root):
            nonlocal kthVal, k
            if not root:
                return
            
            dfs(root.left)

            k -= 1
            if (k == 0):
                kthVal = root.val
                return

            dfs(root.right)
            return
        dfs(root)
        return kthVal