from typing import List

class Solution:
    def evaluate(self, num2: int, num1: int, operand: str) -> int:
        if operand == '+':
            return num1 + num2
        elif operand == '-':
            return num1 - num2
        elif operand == '*':
            return num1 * num2
        elif operand == '/':
            return int(num1 / num2)
        
    def evalRPN(self, tokens: List[str]) -> int:
        # N: len(tokens)
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> Stack Space
        # s = Solution()
        # operand = '+-*/'

        # def dfs():
        #     token = tokens.pop()
        #     if token not in operand:
        #         return int(token)
            
        #     num1 = dfs()
        #     num2 = dfs()
        #     return s.evaluate(num1, num2, token)
        # return dfs()


        # N: len(tokens)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        s = Solution()
        operand = '+-*/'
        stack = []

        for token in tokens:
            if token not in operand:
                stack.append(int(token))
            else:
                stack.append(s.evaluate(stack.pop(), stack.pop(), token))
        return stack[-1]