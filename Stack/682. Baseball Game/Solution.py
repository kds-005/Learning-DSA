from typing import List

class Solution:
    def calPoints(self, operations: List[str]) -> int:
        # N : len(operations)
        # Time Complexity: O(2N)
        # Space Complexity: O(N)
        # n = len(operations)
        # stack = []

        # for operation in operations:
        #     if operation == 'C':
        #         stack.pop()
        #     elif operation == 'D':
        #         stack.append(stack[-1] * 2)
        #     elif operation == '+':
        #         stack.append(stack[-1] + stack[-2])
        #     else:
        #         stack.append(int(operation))
        # return sum(stack)


        # N : len(operations)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(operations)
        stack = []
        finalScore = 0

        for operation in operations:
            if operation == 'C':
                finalScore -= stack.pop()
            elif operation == 'D':
                stack.append(stack[-1] * 2)
                finalScore += stack[-1]
            elif operation == '+':
                stack.append(stack[-1] + stack[-2])
                finalScore += stack[-1]
            else:
                stack.append(int(operation))
                finalScore += stack[-1]
        return finalScore