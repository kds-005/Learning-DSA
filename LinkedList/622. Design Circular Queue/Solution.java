class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode node) {
        this.val = val;
        this.next = node;
    }
}

class MyCircularQueue {
    // N : total no of nodes
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    private static int MAX_LEN;
    private ListNode front;
    private ListNode rear;
    private int length;

    public MyCircularQueue(int k) {
        MAX_LEN = k;
        front = null;
        rear = null;
        length = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        ListNode new_node = new ListNode(value);
        if (isEmpty())
            front = rear = new_node;
        else {
            rear.next = new_node;
            rear = rear.next;
            new_node.next = front;
        }
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        front = front.next;
        rear.next = front;
        length--;
        return true;
    }

    public int Front() {
        return (isEmpty()) ? -1 : front.val;
    }

    public int Rear() {
        return (isEmpty()) ? -1 : rear.val;
    }

    public boolean isEmpty() {
        return (length == 0) ? true : false;
    }

    public boolean isFull() {
        return (length == MAX_LEN) ? true : false;
    }
}