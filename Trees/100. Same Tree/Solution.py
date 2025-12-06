from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # N : no of nodes in the tree
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # def dfs(p, q):
        #     if not p and not q:
        #         return True
            
        #     if (not p or not q or (p.val != q.val)):
        #         return False
            
        #     left = dfs(p.left, q.left)
        #     right = dfs(p.right, q.right)
        #     return left and right
        # return dfs(p, q)


        # # N : no of nodes in the tree
        # # Time Complexity: O(N)
        # # Space Complexity: O(N)
        # if not p and not q:
        #     return True
        # elif (not p or not q or (p.val != q.val)):
        #     return False
        
        # stackP = deque([p])
        # stackQ = deque([q])
        # while stackP and stackQ:
        #     nodeP = stackP.pop()
        #     nodeQ = stackQ.pop()

        #     if not nodeP and not nodeQ:
        #        continue
        #     if (not nodeP or not nodeQ or (nodeP.val != nodeQ.val)):
        #         return False
            
        #     stackP.append(nodeP.left)
        #     stackP.append(nodeP.right)
        #     stackQ.append(nodeQ.left)
        #     stackQ.append(nodeQ.right)
        # return True


        # N : no of nodes in the tree
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if not p and not q:
            return True
        elif (not p or not q or (p.val != q.val)):
            return False
        
        queueP = deque([p])
        queueQ = deque([q])
        while queueP and queueQ:
            nodeP = queueP.popleft()
            nodeQ = queueQ.popleft()

            if not nodeP and not nodeQ:
               continue
            if (not nodeP or not nodeQ or (nodeP.val != nodeQ.val)):
                return False
            
            queueP.append(nodeP.left)
            queueP.append(nodeP.right)
            queueQ.append(nodeQ.left)
            queueQ.append(nodeQ.right)
        return True