from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # N : no of nodes in root
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # prev = float("-inf")
        # def dfs(root):
        #     nonlocal prev
        #     if not root:
        #         return True
            
        #     if not dfs(root.left):
        #         return False

        #     if prev >= root.val:
        #         return False
        #     prev = root.val

        #     if not dfs(root.right):
        #         return False
        #     return True
        # return dfs(root)


        # N : no of nodes in root
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        def dfs(root, low, high):
            if not root: 
                return True
            
            if not (low < root.val < high):
                return False
            
            left = dfs(root.left, low, root.val)
            right = dfs(root.right, root.val, high)
            return left and right
        return dfs(root, float('-inf'), float('inf'))