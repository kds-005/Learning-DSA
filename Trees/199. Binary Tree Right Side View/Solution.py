from collections import deque
from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # N : no of nodes in root
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # def dfs(root, level, rightView):
        #     if not root:
        #         return
            
        #     if level == len(rightView):
        #         rightView.append(root.val)
        #     dfs(root.right, level + 1, rightView)
        #     dfs(root.left, level + 1, rightView)

        #     return
        # rightView = []
        # dfs(root, 0, rightView)
        # return rightView


        # N : no of nodes in root
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not root:
            return []
        
        rightView = []
        q = deque([root])
        while q:
            n = len(q)
            for i in range(n):
                node = q.popleft()
                
                if i == n - 1:
                    rightView.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return rightView