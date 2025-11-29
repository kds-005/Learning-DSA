import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.prev = this.next = null;
    }
}

class LinkedList1 {
    private Node head;
    private Node tail;
    private Map<Integer, Node> nodeMap;

    public LinkedList1() {
        this.nodeMap = new HashMap<>();
        this.head = this.tail = null;
    }

    public int length() {
        return this.nodeMap.size();
    }
    
    public void pushLeft(int val) {
        if (nodeMap.containsKey(val)) return;
        Node new_node = new Node(val);
        nodeMap.put(val, new_node);

        if (head == null) head = tail= new_node;
        else {
            head.prev = new_node;
            new_node.next = head;
            head = head.prev;
        }
    }

    public void pushRight(int val) {
        if (nodeMap.containsKey(val)) return;
        Node new_node = new Node(val);
        nodeMap.put(val, new_node);

        if (tail == null) head = tail = new_node;
        else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = tail.next;
        }
    }

    public int pop(int val) {
        if (length() == 0) return -1;

        Node curr = nodeMap.remove(val);
        if (head == tail & tail == curr) {
            head = tail = null;
        } else if (head == curr) {
            head = head.next;
            head.prev = null;
        } else if (tail == curr) {
            tail = tail.prev;
            tail.next = null;
        } else {
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
        }
        return curr.val;
    }

    public int popLeft() {
        return pop(head.val);
    }

    public int popRight() {
        return pop(tail.val);
    }
    
}

class LFUCache {
    // N : total no of nodes
    // Time Complexity: O(1)
    // Space Complexity: O(N)
    private static int MAX_LIMIT;
    private Map<Integer, Integer[]> keyMap;
    private Map<Integer, LinkedList1> countMap;
    private int lfu;
    public LFUCache(int capacity) {
        MAX_LIMIT = capacity;
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        lfu = 0;
    }

    private void updateCounter(int key) {
        int count = keyMap.get(key)[1];
        keyMap.put(key, new Integer[] {keyMap.get(key)[0], count + 1});

        countMap.get(count).pop(key);
        if (!countMap.containsKey(count + 1)) countMap.put(count + 1, new LinkedList1());
        countMap.get(count + 1).pushLeft(key);
        if (lfu == count && countMap.get(count).length() == 0) lfu++;
    }
    
    public int get(int key) {
        if (keyMap.size() == 0 || !keyMap.containsKey(key)) return -1;
        updateCounter(key);
        return keyMap.get(key)[0];
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            keyMap.get(key)[0] = value;
            updateCounter(key);
        } else {
            if (keyMap.size() == MAX_LIMIT) {
                keyMap.remove(countMap.get(lfu).popRight());
            }
            keyMap.put(key, new Integer[]{value, 1});
            if (!countMap.containsKey(1)) countMap.put(1, new LinkedList1());
            countMap.get(1).pushLeft(key);
            lfu = 1;
        }
    }
}