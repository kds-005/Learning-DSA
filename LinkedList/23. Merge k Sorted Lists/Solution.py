import heapq
from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # N : total no of nodes, K : len(lists)
        # Time Complexity: O(N logk)
        # Space Complexity: O(K)
        heapList = []
        for head in lists:
            if not head:
                continue
            heapList.append([head.val, id(head), head])
        
        heapq.heapify(heapList)
        head = tail = ListNode()
        while heapList:
            num, idx, node = heapq.heappop(heapList)

            if node.next:
                heapq.heappush(heapList, [node.next.val, id(node.next), node.next])

            node.next = None
            tail.next = node
            tail = tail.next
        return head.next