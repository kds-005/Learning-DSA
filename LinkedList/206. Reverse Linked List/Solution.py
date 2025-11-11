from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # N : no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        if not head:
            return head

        dummy = ListNode(0, ListNode(0, head))
        node1, node2, node3 = head, dummy.next, dummy
        
        while node1:
            node2.next = node3
            
            node3 = node2
            node2 = node1
            node1 = node1.next
        
        node2.next = node3
        head.next = None
        return node2