from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # N : no of nodes, K : val of k
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        def reverseList(head):
            dummy = ListNode(0, ListNode(0, head))
            node1, node2, node3 = dummy, dummy.next, head
            while node3:
                node2.next = node1
                node1 = node2
                node2 = node3
                node3 = node3.next
            node2.next = node1
            head.next = None
            return head
        
        def reverseRange(head, left, right):
            dummy = ListNode(0, head)
            leftOuter = rightOuter = leftInner = rightOuter = None
            curr = dummy
            for i in range(right + 1):
                if not curr:
                    return head
                if (i + 1) == left:
                    leftOuter = curr
                elif i == left:
                    leftInner = curr
                elif i == right:
                    rightInner = curr
                    rightOuter = curr.next
                curr = curr.next
            
            leftOuter.next = None
            rightInner.next = None
            reverseList(leftInner)
            leftOuter.next = rightInner
            leftInner.next = rightOuter
            return dummy.next
        
        if k == 1 or not head.next:
            return head

        curr = head
        length = 0
        while curr:
            length += 1
            curr = curr.next

        start = 0
        end = 0
        while end < length:
            start = end + 1
            end = start + k - 1
            head = reverseRange(head, start, end)
        return head