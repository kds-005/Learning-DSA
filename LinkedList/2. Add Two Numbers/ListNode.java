// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // N : no of nodes in l1, M : no of nodes in l2
        // Time Complexity: O(max(M, N))
        // Space Complexity: O(max(M, N))
        int carry = 0;
        ListNode total = new ListNode();
        ListNode node = total;

        while (l1 != null && l2 != null) {
            int currSum = l1.val + l2.val + carry;
            carry = currSum / 10;
            currSum = currSum % 10;
            node.next = new ListNode(currSum, null);
            node = node.next;

            if (l1.next == null && l2.next != null) l1.next = new ListNode(0, null);
            if (l2.next == null && l1.next != null) l2.next = new ListNode(0, null);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry != 0) node.next = new ListNode(carry, null);
        return total.next;
    }
}