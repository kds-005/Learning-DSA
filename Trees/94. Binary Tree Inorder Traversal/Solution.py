from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # N : no of nodes in tree
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # inorder = []
        # def dfs(root):
        #     if not root:
        #         return
            
        #     dfs(root.left)
        #     inorder.append(root.val)
        #     dfs(root.right)
        #     return
        # dfs(root)
        # return inorder

        # N : no of nodes in tree
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> with Output Array
        inorder = []
        stack = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            inorder.append(root.val)
            root = root.right
        return inorder