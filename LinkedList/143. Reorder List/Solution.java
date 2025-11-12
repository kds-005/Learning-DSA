// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        // N : no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        if (head.next == null) return;


        // Finding the left and right portion of the list using slow and fast approach
        ListNode dummy = new ListNode(0, head);
        ListNode left = head;
        ListNode right = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next.next;
            right = right.next;
        }
        curr = right;
        right = right.next;
        curr.next = null;

        // Reverse the right list
        dummy = new ListNode(0, new ListNode(0, right));
        ListNode node1 = dummy;
        ListNode node2 = dummy.next;
        curr = dummy.next.next;
        while (curr != null) {
            node2.next = node1;

            node1 = node2;
            node2 = curr;
            curr = curr.next;
        }
        node2.next = node1;
        right.next = null;
        right = node2;

        // Reorder the head list
        head = curr = left;
        left = left.next;
        while (left != null) {
            curr.next = right;
            right = right.next;
            curr.next.next = left;
            left = left.next;
            curr = curr.next.next;
        }
        curr.next = right;
    }
}