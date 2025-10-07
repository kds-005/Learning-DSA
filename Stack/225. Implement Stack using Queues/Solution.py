from collections import deque

# N : len(storeQueue), M : len(mainQueue) == 1
# Time Complexity: Creating Object - O(1), push() - O(1), pop() - O(N), top() - O(1), empty() - O(1)
# Space Complexity: O(2N)
# class MyStack:

#     def __init__(self):
#         self.mainQueue = deque()
#         self.storeQueue = deque()

#     def push(self, x: int) -> None:
#         if len(self.mainQueue) == 0:
#             self.mainQueue.append(x)
#         else:
#             self.storeQueue.append(self.mainQueue.popleft())
#             self.mainQueue.append(x)

#     def pop(self) -> int:
#         n = len(self.storeQueue)
#         deletedVal = self.mainQueue.popleft()
#         if n == 0:
#             return deletedVal
#         for i in range(n - 1):
#             self.storeQueue.append(self.storeQueue.popleft())
#         self.mainQueue.append(self.storeQueue.popleft())
#         return deletedVal

#     def top(self) -> int:
#         return self.mainQueue[0]

#     def empty(self) -> bool:
#         return len(self.mainQueue) == 0


# M : len(mainQueue)
# Time Complexity: Creating Object - O(1), push() - O(N), pop() - O(1), top() - O(1), empty() - O(1)
# Space Complexity: O(N)


class MyStack:

    def __init__(self):
        self.mainQueue = deque()

    def push(self, x: int) -> None:
        self.mainQueue.append(x)
        m = len(self.mainQueue)
        for i in range(m - 1):
            self.mainQueue.append(self.mainQueue.popleft())

    def pop(self) -> int:
        return self.mainQueue.popleft()

    def top(self) -> int:
        return self.mainQueue[0]

    def empty(self) -> bool:
        return len(self.mainQueue) == 0