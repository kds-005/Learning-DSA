from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # N : no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        dummy = ListNode(0, head)
        curr = head
        left = dummy
        while curr:
            n -= 1
            curr = curr.next
            if n < 0:
                left = left.next
            
        left.next = left.next.next
        return dummy.next