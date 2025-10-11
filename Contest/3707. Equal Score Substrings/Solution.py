class Solution:
    def scoreBalance(self, s: str) -> bool:
        n = len(s)
        totalSum = 0
        for ch in s:
            totalSum += ord(ch) - ord('a') + 1
        currSum = 0
        for ch in s[:n-1]:
            currSum += ord(ch) - ord('a') + 1
            if currSum == totalSum - currSum:
                return True
        return False