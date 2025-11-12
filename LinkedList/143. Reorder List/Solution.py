from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # N : no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        if not head.next:
            return
    
        # Finding the left and right portion of the list using slow and fast approach
        dummy = ListNode(0, head)
        left = fast = head
        right = dummy

        while fast and fast.next:
            fast = fast.next.next
            right = right.next

        temp = right
        right = right.next
        temp.next = None

        # Reverse the right list
        dummy = ListNode(0, ListNode(0, right))
        node1, node2, node3 = right, dummy.next, dummy
        while node1:
            node2.next = node3

            node3 = node2
            node2 = node1
            node1 = node1.next
        
        node2.next = node3
        right.next = None
        right = node2

        # Reorder the head list
        head = curr = left
        left = left.next
        while left:
            curr.next = right
            right = right.next
            curr = curr.next
            curr.next = left
            left = left.next
            curr = curr.next
        curr.next = right