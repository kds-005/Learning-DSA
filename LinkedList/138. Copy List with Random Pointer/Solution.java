import java.util.*;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        // N : no of nodes
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        HashMap<Node, Node> mop = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            mop.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            mop.get(curr).next = mop.get(curr.next);
            mop.get(curr).random = mop.get(curr.random);
            curr = curr.next;
        }
        return mop.get(head);
    }
}