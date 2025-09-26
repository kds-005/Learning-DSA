class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # N : len(s1), M : len(s2)
        # Time Complexity: O(N logN + M * N logN)
        # Space Complexity: O(2N)
        # n = len(s1)
        # m = len(s2)
        # if n == 1 and s1 in s2:
        #     return True
        # sortedS1 = sorted(s1)
        # for i in range(m - n + 1):
        #     partSortedS2 = sorted(s2[i: i + n])
        #     if partSortedS2 == sortedS1:
        #         return True
        # return False

        # N : len(s1), M : len(s2)
        # Time Complexity: O(M * 26)
        # Space Complexity: O(2 * 26)
        n = len(s1)
        m = len(s2)
        s1Map = [0] * 26
        for ch in s1:
            s1Map[ord(ch) - ord('a')] += 1
        
        l, r = 0, 0
        s2Map = [0] * 26
        while r < m:
            s2Map[ord(s2[r]) - ord('a')] += 1
            if (r - l + 1) > n:
                s2Map[ord(s2[l]) - ord('a')] -= 1
                l += 1
            if (r - l + 1) == n:
                if s1Map == s2Map:
                    return True
            r += 1
        return False