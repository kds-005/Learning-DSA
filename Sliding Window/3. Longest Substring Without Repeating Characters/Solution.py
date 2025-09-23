class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # N : len(s), M : Longest unique SubString
        # Time Complexity: O(N^2)
        # Space Complexity: O(M)
        # n = len(s)
        # longestString = 0
        # for i in range(n):
        #     charSet = set()
        #     for j in range(i, n):
        #         if s[j] in charSet:
        #             longestString = max(longestString, j - i)
        #             break
        #         charSet.add(s[j])
        #     longestString = max(longestString, len(charSet))
        # return longestString


        # N : len(s), M : Longest unique SubString
        # Time Complexity: O(N)
        # Space Complexity: O(M)
        n = len(s)
        charSet = set()
        longestString = 0
        l, r = 0, 0
        while r < n:
            if s[r] in charSet:
                longestString = max(longestString, r - l)
                charSet.remove(s[l])
                l += 1
                continue
            charSet.add(s[r])
            r += 1
        longestString = max(longestString, r - l)
        return longestString