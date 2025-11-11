// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // N : no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        if (head == null) return head;

        ListNode dummy = new ListNode(0, new ListNode(0, head));
        ListNode node1 = head, node2 = dummy.next, node3 = dummy;
        
        while (node1 != null) {
            node2.next = node3;

            node3 = node2;
            node2 = node1;
            node1 = node1.next;
        }
        node2.next = node3;
        head.next = null;
        return node2;
    }
}