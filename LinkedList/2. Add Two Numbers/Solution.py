from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # N : no of nodes in l1, M : no of nodes in l2
        # Time Complexity: O(max(M, N))
        # Space Complexity: O(max(M, N))
        carry = 0
        total = head = ListNode()
        while l1 and l2:
            currSum = l1.val + l2.val + carry
            carry = currSum // 10
            currSum = (currSum % 10) 
            
            total.next = ListNode(currSum, None)
            total = total.next

            if not l1.next and l2.next:
                l1.next = ListNode(0, None)
            
            if not l2.next and l1.next:
                l2.next = ListNode(0, None)
                
            l1 = l1.next
            l2 = l2.next

        if carry != 0:
            total.next = ListNode(carry)
        return head.next