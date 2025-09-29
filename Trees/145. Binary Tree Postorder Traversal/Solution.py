from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # N : no of Nodes
        # Time Complexity: O(N)
        # Space Complexity: O(2N)
        # postOrder = []
        # def dfs(root):
        #     if root is None:
        #         return
        #     dfs(root.left)
        #     dfs(root.right)
        #     postOrder.append(root.val)
        #     return
        # dfs(root)
        # return postOrder
        

        # N : no of Nodes
        # Time Complexity: O(N)
        # Space Complexity: O(2N)
        postOrder = []
        stack = [root]
        while stack:
            node = stack.pop()
            if node is None:
                continue
            postOrder.append(node.val)
            stack.append(node.left)
            stack.append(node.right)
        return postOrder[::-1]