from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # N : n from input
        # Time Complexity: O(2^(2 * N) * N)
        # Space Complexity: O(2N * 2N)
        # parentheses = []
        # def isValidString(sub):
        #     stack = []
        #     for para in sub:
        #         if para == '(':
        #             stack.append(para)
        #         elif para == ')' and len(stack) > 0 and stack[-1] == '(':
        #             stack.pop()
        #         else:
        #             return False
        #     return len(stack) == 0

        # def backtract(openParentheses, closeParentheses, sub):
        #     if openParentheses == closeParentheses == n:
        #         if isValidString(sub):
        #             parentheses.append(sub)
        #         return
        #     if openParentheses > n or closeParentheses > n:
        #         return
            
        #     backtract(openParentheses + 1, closeParentheses, sub + '(')
        #     backtract(openParentheses, closeParentheses + 1, sub + ')')
        #     return

        # backtract(0, 0, '')
        # return parentheses

        # N : n from input
        # Time Complexity: O(2^(2 * N)) -> witout constraints but with it will be less
        # Space Complexity: O(2N)
        parentheses = []
        def backtract(openParentheses, closeParentheses, sub):
            if len(sub) >= n * 2:
                parentheses.append(sub)
                return
            
            if openParentheses < n and closeParentheses <= openParentheses:
                backtract(openParentheses + 1, closeParentheses, sub + '(')
            if closeParentheses < n:
                backtract(openParentheses, closeParentheses + 1, sub + ')')

            return
        backtract(0, 0, '')
        return parentheses