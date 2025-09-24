from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # N : Total no of Nodes
        # Time Complexity: O(N)
        # Space Complexity: O(2N)
        # preOrder = []
        # def dfs(root):
        #     if root is None:
        #         return
            
        #     preOrder.append(root.val)
        #     dfs(root.left)
        #     dfs(root.right)
        
        # dfs(root)
        # return preOrder

        # N : Total no of Nodes
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        preOrder = []
        stack = [root]
        while len(stack) > 0:
            node = stack.pop()
            if node is None:
                continue
            preOrder.append(node.val)
            stack.append(node.right)
            stack.append(node.left)
        return preOrder