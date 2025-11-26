from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        # N : total no of nodes
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        def reverse(head):
            dummy = ListNode(0, ListNode(0, head))
            node1, node2, node3 = dummy, dummy.next, head
            while node3:
                node2.next = node1
                
                node1 = node2
                node2 = node3
                node3 = node3.next
            
            node2.next = node1
            head.next = None
            return node2

        dummy = ListNode(0 , head)
        curr = dummy
        leftNode = rightNode = None
        count = -1
        while curr:
            count += 1
            if not leftNode and (count + 1) == left:
                leftNode = curr
                head = curr.next
            if not rightNode and count == right:
                rightNode = curr.next
                curr.next = None
                break
            curr = curr.next
        reversedHead = reverse(head)
        leftNode.next = reversedHead
        head.next = rightNode
        return dummy.next