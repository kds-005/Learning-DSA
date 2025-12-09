from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        # N : no of node in the Tree
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        def dfs(root, key):
            if not root:
                return root
            
            if root.val < key:
                root.right = dfs(root.right, key)
            elif root.val > key:
                root.left = dfs(root.left, key)
            else:
                if not root.left:
                    return root.right
                elif not root.right:
                    return root.left
                else:
                    curr = root.right
                    while curr.left:
                        curr = curr.left
                    
                    root.val = curr.val
                    root.right = dfs(root.right, root.val)
            return root
        return dfs(root, key)