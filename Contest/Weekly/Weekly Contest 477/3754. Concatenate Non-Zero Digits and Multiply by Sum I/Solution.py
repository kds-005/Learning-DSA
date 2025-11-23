class Solution:
    def sumAndMultiply(self, n: int) -> int:
        # N: no of digits of 'n'
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        if n == 0:
            return 0
        s = str(n)
        summ = 0
        digit = ''
        for i in range(len(s)):
            if s[i] != '0':
                digit += s[i]
                summ += int(s[i])
        return int(digit) * summ