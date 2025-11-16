class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # M : len(s), N : len(t)
        # Time Complexity: O(max(MlogM, NlogN))
        # Space Complexity: O(1)
        # s = sorted(s)
        # t = sorted(t)
        # return s == t


        # M : len(s), N : len(t)
        # Time Complexity: O(max(M, N))
        # Space Complexity: O(26)
        sFreq = [0] * 26
        
        for ch in s:
            sFreq[ord(ch) - ord('a')] += 1

        for ch in t:
            sFreq[ord(ch) - ord('a')] -= 1
        
        for i in range(26):
            if sFreq[i] != 0: 
                return False
        return True