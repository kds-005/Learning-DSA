from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # N : n from input
        # Time Complexity: O(2^(2 * N) * N)
        # Space Complexity: O(2N * 2N)
        # parentheses = []
        # def isValidString(brackets):
        #     stack = []
        #     for para in brackets:
        #         if para == '(':
        #             stack.append(para)
        #         elif para == ')' and len(stack) > 0 and stack[-1] == '(':
        #             stack.pop()
        #         else:
        #             return False
        #     return len(stack) == 0

        # def backtract(openParentheses, closeParentheses, brackets):
        #     if openParentheses == closeParentheses == n:
        #         if isValidString(brackets):
        #             parentheses.append(brackets)
        #         return
        #     if openParentheses > n or closeParentheses > n:
        #         return
            
        #     backtract(openParentheses + 1, closeParentheses, brackets + '(')
        #     backtract(openParentheses, closeParentheses + 1, brackets + ')')
        #     return

        # backtract(0, 0, '')
        # return parentheses

        # N : n from input
        # Time Complexity: O(2^(2 * N)) -> witout constraints but with it will be less
        # Space Complexity: O(2N)
        parentheses = []
        def backtract(openParentheses, closeParentheses, brackets):
            if len(brackets) >= n * 2:
                parentheses.append(brackets)
                return
            
            if openParentheses < n and closeParentheses <= openParentheses:
                backtract(openParentheses + 1, closeParentheses, brackets + '(')
            if closeParentheses < n:
                backtract(openParentheses, closeParentheses + 1, brackets + ')')

            return
        backtract(0, 0, '')
        return parentheses