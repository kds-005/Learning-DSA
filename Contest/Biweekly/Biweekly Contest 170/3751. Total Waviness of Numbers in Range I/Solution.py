class Solution:
    def totalWaviness(self, num1: int, num2: int) -> int:
        # N : no of number btw num1 and num2, M : no of digits
        # Time Complexity: O(N * M)
        # Space Complexity: O(M)
        totalWav = 0
        for num in range(num1, num2 + 1):
            s = str(num)
            for i in range(1, len(s) - 1):
                if s[i - 1] < s[i] and s[i] > s[i + 1]:
                    totalWav += 1
                elif s[i - 1] > s[i] and s[i] < s[i + 1]:
                    totalWav += 1
        return totalWav