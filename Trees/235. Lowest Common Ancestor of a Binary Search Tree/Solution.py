from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # N : no of nodes in the Tree
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # def dfs(root):
        #     if not root:
        #         return None
            
        #     if root.val > p.val and root.val > q.val:
        #         return dfs(root.left)
        #     elif root.val < p.val and root.val < q.val:
        #         return dfs(root.right)
        #     else:
        #         return root
        # return dfs(root)


        # N : no of nodes in the Tree
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        stack = deque([root])
        while stack:
            node = stack.pop()
            if (node.val > p.val and node.val > q.val):
                stack.append(node.left)
            elif (node.val < p.val and node.val < q.val):
                stack.append(node.right)
            else:
                return node