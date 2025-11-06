class Solution:
    def reverseDegree(self, s: str) -> int:
        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(s)
        reverseDegree = 0
        for i in range(n):
            reverseDegree += (ord('z') - ord(s[i]) + 1) * (i + 1)
        return reverseDegree