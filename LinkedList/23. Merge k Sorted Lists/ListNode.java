import java.util.*;

//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Comp {
    public int val;
    public ListNode node;

    public Comp(int val, ListNode node) {
        this.val = val;
        this.node = node;
    }

    public String toString(){
        return "[" + this.val + " ," + this.node + "]";
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // N : total no of nodes, K : len(lists)
        // Time Complexity: O(N logk)
        // Space Complexity: O(K)
        Queue<Comp> minHeap = new PriorityQueue<>((x, y) -> {
            return x.val - y.val;
        });

        for (ListNode head: lists) 
            if (head != null) 
                minHeap.add(new Comp(head.val, head));

        ListNode head, tail;
        head = tail = new ListNode();
        while (minHeap.size() != 0) {
            Comp temp = minHeap.remove();
            ListNode curr = temp.node;
            if (curr.next != null) minHeap.add(new Comp(curr.next.val, curr.next));

            tail.next = curr;
            tail = tail.next;
        }
        return head.next;
    }
}