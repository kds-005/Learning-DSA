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
        ListNode node1 = dummy, node2 = dummy.next, node3 = dummy.next.next;
        while (node3 != null) {
            node2.next = node1;

            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
        node2.next = node1;
        head.next = null;
        return node2;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // N : total no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy, leftNode = null, rightNode = null;

        int count = -1;
        while (curr != null) {
            count += 1;
            if (leftNode == null && (count + 1) == left) {
                leftNode = curr;
                head = curr.next;
            }
            if (rightNode == null && count == right) {
                rightNode = curr.next;
                curr.next = null;
                break;
            }
            curr = curr.next;
        }
        ListNode reverseHead = reverseList(head);
        leftNode.next = reverseHead;
        head.next = rightNode;
        return dummy.next;
    }
}