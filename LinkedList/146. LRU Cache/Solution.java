import java.util.*;

class DoubleListNode {
    public int key;
    public int val;
    public DoubleListNode prev;
    public DoubleListNode next;

    public DoubleListNode(int key, int val, DoubleListNode prev, DoubleListNode next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    // N : total no of nodes
    // Time Complexity: O(1) for all methods
    // Space Complexity: O(N) -> including HashMap & Doubly Linked List
    private static int MAX_LIMIT;
    private DoubleListNode head;
    private DoubleListNode tail;
    private Map<Integer, DoubleListNode> nodeMap;

    public LRUCache(int capacity) {
        MAX_LIMIT = capacity;
        head = tail = null;
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        int val = delete(key);
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) delete(key);
        else if (nodeMap.size() == MAX_LIMIT) delete(tail.key);

        DoubleListNode new_node = new DoubleListNode(key, value, null, null);
        nodeMap.put(key, new_node);

        if (head == null) {
            head = tail = new_node;
        } else {
            new_node.next = head;
            head.prev = new_node;
            head = head.prev;
        }
    }

    private int delete(int key) {
        if (!nodeMap.containsKey(key)) return -1;

        DoubleListNode delNode = nodeMap.get(key);
        if (head == tail && tail == delNode) {
            head = tail = null;
        } else if (head == delNode) {
            head = head.next;
            head.prev = null;
        } else if (tail == delNode) {
            tail = tail.prev;
            tail.next = null;
        } else {
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
        }

        nodeMap.remove(key);
        return delNode.val;
    }
}