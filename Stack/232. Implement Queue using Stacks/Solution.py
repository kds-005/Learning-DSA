# N : Total number of elements added
# Time Complexity : Creating MyQueue Object - O(1), push() - O(1), pop() - O(N), peek() - O(N), empty() - O(1)
# Space Complexity : O(N)
# class MyQueue:
#     def __init__(self):
#         self.mainStack = []
#         self.storeStack = []

#     def push(self, x: int) -> None: 
#         self.mainStack.append(x)

#     def pop(self) -> int:
#         n = len(self.mainStack)
#         deletedVal = None
#         for i in range(n):
#             deletedVal = self.mainStack.pop()
#             if i == n - 1:
#                 continue
#             self.storeStack.append(deletedVal)
        
#         while len(self.storeStack) > 0:
#             self.mainStack.append(self.storeStack.pop())

#         return deletedVal

#     def peek(self) -> int:
#         n = len(self.mainStack)
#         deletedVal = None
#         for i in range(n):
#             deletedVal = self.mainStack.pop()
#             self.storeStack.append(deletedVal)
        
#         while len(self.storeStack) > 0:
#             self.mainStack.append(self.storeStack.pop())
            
#         return deletedVal

#     def empty(self) -> bool:
#         return len(self.mainStack) == 0


# N : Total number of elements added
# Time Complexity : Creating MyQueue Object - O(1), push() - O(1), pop() - O(N), peek() - O(N), empty() - O(1)
# Space Complexity : O(N)
class MyQueue:
    def __init__(self):
        self.pushStack = []
        self.popStack = []

    def push(self, x: int) -> None: 
        self.pushStack.append(x)

    def pop(self) -> int:
        n = len(self.pushStack)
        m = len(self.popStack)
        if m == 0:
            for i in range(n):
                self.popStack.append(self.pushStack.pop())
        return self.popStack.pop()

    def peek(self) -> int:
        n = len(self.pushStack)
        m = len(self.popStack)
        if m == 0:
            for i in range(n):
                self.popStack.append(self.pushStack.pop())
        return self.popStack[-1]

    def empty(self) -> bool:
        return len(self.pushStack) == 0 and len(self.popStack) == 0