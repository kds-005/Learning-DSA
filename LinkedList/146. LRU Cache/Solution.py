class DoubleListNode:
    def __init__(self, key = 0, val = 0, prev = None, next = None):
        self.key = key
        self.val = val
        self.prev = prev
        self.next = next

class LRUCache:
    # N : total no of nodes
    # Time Complexity: O(1) for all methods
    # Space Complexity: O(N) -> including HashMap & Doubly Linked List
    def __init__(self, capacity: int):
        self.MAX_LIMIT = capacity
        self.head = self.tail = None
        self.nodeMap = {}

    def get(self, key: int) -> int:
        if key not in self.nodeMap:
            return -1
        val = self.__delete(key)
        self.put(key, val)
        return val

    def put(self, key: int, value: int) -> None:
        if key in self.nodeMap:
            self.__delete(key)
        elif len(self.nodeMap) == self.MAX_LIMIT:
            self.__delete(self.tail.key)
        
        new_node = DoubleListNode(key, value)
        self.nodeMap[key] = new_node
        
        if not self.head:
            self.head = self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = self.head.prev

    
    def __delete(self, key: int) -> int:
        if key not in self.nodeMap:
            return None

        delNode = self.nodeMap[key]

        if self.head == self.tail == delNode:
            self.head = self.tail = None
        elif self.head == delNode:
            self.head = self.head.next
            self.head.prev = None
        elif self.tail == delNode:
            self.tail = self.tail.prev
            self.tail.next = None
        else:
            delNode.prev.next = delNode.next
            delNode.next.prev = delNode.prev
        self.nodeMap.pop(key)
        return delNode.val