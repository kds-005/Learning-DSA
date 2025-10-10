# N : no of elements in a stack
# Time Complexity : Creating MinStack Object - O(1), push() - O(1), pop() - O(1), top() - O(1), getMin() - O(N)
# Space Complexity : O(N)
# class MinStack:

#     def __init__(self):
#         self.stack = []

#     def push(self, val: int) -> None:
#         self.stack.append(val)

#     def pop(self) -> None:
#         self.stack.pop()

#     def top(self) -> int:
#         return self.stack[-1]

#     def getMin(self) -> int:
#         return min(self.stack)


# N : no of elements in a stack
# Time Complexity : Creating MinStack Object - O(1), push() - O(1), pop() - O(1), top() - O(1), getMin() - O(N)
# Space Complexity : O(N)
class MinStack:

    def __init__(self):
        self.mainStack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.mainStack.append(val)
        if len(self.minStack) == 0:
            self.minStack.append(val)
        else:
            self.minStack.append(min(val, self.minStack[-1]))

    def pop(self) -> None:
        self.mainStack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.mainStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]