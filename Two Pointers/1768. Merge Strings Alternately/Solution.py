class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        # Time Complexity: O(max(n1, n2))
        # Space Complexity: O(n1 + n2)
        n1 = len(word1)
        n2 = len(word2)
        l = 0
        r = 0

        res = ""
        while l < n1 and r < n2:
            res += word1[l]
            res += word2[r]
            l += 1
            r += 1
        
        while l < n1:
            res += word1[l]
            l += 1
        
        while r < n2:
            res += word2[r]
            r += 1
        return res