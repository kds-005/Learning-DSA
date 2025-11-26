class ListNode:
    def __init__(self, value = 0, node = None):
        self.val = value
        self.next = node

class MyCircularQueue:
    # N : total no of nodes
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def __init__(self, k: int):
        self.MAX_LEN = k
        self.length = 0
        self.front = None
        self.rear = None

    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False

        new_node = ListNode(value, None)
        if self.isEmpty():
            self.front = self.rear = new_node
        else:
            self.rear.next = new_node
            self.rear = self.rear.next
            self.rear.next = self.front
        self.length += 1
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False
        
        self.front = self.front.next
        self.rear.next = self.front
        self.length -= 1
        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        return self.front.val

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        return self.rear.val

    def isEmpty(self) -> bool:
        return True if self.length == 0 else False

    def isFull(self) -> bool:
        return True if self.length == self.MAX_LEN else False