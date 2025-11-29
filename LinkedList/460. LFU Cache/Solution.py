class Node:
    def __init__(self, val = 0, prev = None, next = None):
        self.val = val
        self.prev = prev
        self.next = next

class LinkedList:
    def __init__(self):
        self.head = self.tail = None
        self.nodeMap = {}

    def length(self) -> int:
        return len(self.nodeMap)
    
    def pushLeft(self, val: int) -> None:
        if val in self.nodeMap:
            return None
        
        new_node = Node(val)
        self.nodeMap[val] = new_node
        
        if self.head == None:
            self.head = self.tail = new_node
        else:
            self.head.prev = new_node
            new_node.next = self.head
            self.head = self.head.prev
    
    def pushRight(self, val: int) -> None:
        if val in self.nodeMap:
            return None

        new_node = Node(val)
        self.nodeMap[val] = new_node
        
        if self.tail == None:
            self.tail = self.head = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = self.tail.next
    
    def popleft(self) -> int:
        val = self.pop(self.head.val)
        return val

    def popRight(self) -> int:
        val = self.pop(self.tail.val)
        return val
    
    def pop(self, val) -> int:
        if self.length() == 0:
            return -1

        curr = self.nodeMap.pop(val)
        if self.head == self.tail == curr:
            self.head = self.tail = None
        elif self.head == curr:
            self.head =  self.head.next
            self.head.prev = None
        elif self.tail == curr:
            self.tail = self.tail.prev
            self.tail.next = None
        else:
            curr.next.prev = curr.prev
            curr.prev.next = curr.next
        return curr.val

class LFUCache:
    # N : total no of nodes
    # Time Complexity: O(1)
    # Space Complexity: O(N)
    def __init__(self, capacity: int):
        self.MAX_LIMIT = capacity
        self.lfu = 0
        self.keyMap = {}
        self.countMap = {}

    def updateCounter(self, key: int) -> None:
        curr_count = self.keyMap[key][1]
        self.countMap[curr_count].pop(key)
        if (curr_count + 1) not in self.countMap:
                self.countMap[curr_count + 1] = LinkedList()
        self.countMap[curr_count + 1].pushLeft(key)
        self.keyMap[key][1] += 1
        
        if self.countMap[curr_count].length() == 0 and self.lfu == curr_count:
            self.lfu += 1


    def get(self, key: int) -> int:
        if key not in self.keyMap:
            return -1
        self.updateCounter(key)
        return self.keyMap[key][0]

    def put(self, key: int, value: int) -> None:
        if key in self.keyMap:
            self.keyMap[key][0] = value
            self.updateCounter(key)
        else:
            if len(self.keyMap) == self.MAX_LIMIT:
                self.keyMap.pop(self.countMap[self.lfu].popRight())
            self.keyMap[key] = [value, 1]
            if 1 not in self.countMap:
                self.countMap[1] = LinkedList()
            self.countMap[1].pushLeft(key)
            self.lfu = 1
