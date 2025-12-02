//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0, new ListNode(0, head));
        ListNode node1 = dummy;
        ListNode node2 = dummy.next;
        ListNode node3 = head;
        while (node3 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
        node2.next = node1;
        head.next = null;
        return head;
    }

    private ListNode reverseRange(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        ListNode leftOuter, leftInner, rightInner, rightOuter;
        leftOuter = leftInner = rightInner = rightOuter = null;
        for (int i = 0; i <= right; i++) {
            if (curr == null) return head;
            if ((i + 1) == left) leftOuter = curr;
            else if (i == left) leftInner = curr;
            else if (i == right) {
                rightInner = curr;
                rightOuter = curr.next;
            }
            curr = curr.next;
        }

        leftOuter.next = null;
        rightInner.next = null;
        reverseList(leftInner);
        leftOuter.next = rightInner;
        leftInner.next = rightOuter;
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // N : no of nodes, K : val of k
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        if (k == 1 || head.next == null) return head;
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        int start = 0, end = 0;
        while (end < length) {
            start = end + 1;
            end = start + k - 1;
            head = reverseRange(head, start, end);
        }
        return head;
    }
}