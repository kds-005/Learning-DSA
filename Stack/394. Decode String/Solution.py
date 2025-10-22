class Solution:
    def decodeString(self, s: str) -> str:
        # N : len(s)
        # Time Complexity; O(N)
        # Space Complexity; O(N)
        n = len(s)
        decodeStack = []
        i = 0
        while i < n:
            if s[i].isdigit():
                curr = ''
                while i < n and s[i].isdigit():
                    curr += s[i]
                    i += 1
                decodeStack.append(curr)
            elif s[i].isalpha():
                curr = ''
                while i < n and s[i].isalpha():
                    curr += s[i]
                    i += 1
                if decodeStack and decodeStack[-1].isalpha():
                    decodeStack[-1] += curr
                else:
                    decodeStack.append(curr)
            elif s[i] == ']':
                curr = decodeStack.pop()
                decodeStack.pop()
                curr *= int(decodeStack.pop())
                if decodeStack and decodeStack[-1].isalpha():
                    decodeStack[-1] += curr
                else:
                    decodeStack.append(curr)
                i += 1
            else:
                decodeStack.append(s[i])
                i += 1
        return decodeStack[-1]