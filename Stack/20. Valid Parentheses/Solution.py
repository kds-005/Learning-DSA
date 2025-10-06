class Solution:
    def isValid(self, s: str) -> bool:
        # N : len(s)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # n = len(s)
        # stack = []
        # for ch in s:
        #     if ch == ')' and len(stack) > 0 and stack[-1] == '(':
        #         stack.pop()
        #     elif ch == '}' and len(stack) > 0 and stack[-1] == '{':
        #         stack.pop()
        #     elif ch == ']' and len(stack) > 0 and stack[-1] == '[':
        #         stack.pop()
        #     else:
        #         stack.append(ch)
        # return True if len(stack) == 0 else False


        # N : len(s)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(s)
        bracketMap = {')' : '(', '}' : '{', ']' : '['}
        stack = []
        for ch in s:
            if ch not in bracketMap:
                stack.append(ch)
                continue
            if len(stack) <= 0 or stack[-1] != bracketMap[ch]:
                return False
            stack.pop()
        return True if len(stack) == 0 else False