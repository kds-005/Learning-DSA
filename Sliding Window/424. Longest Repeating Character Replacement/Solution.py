from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # N : len(s)
        # Time Complexity: O(N^2)
        # Space Complexity: O(26)
        # n = len(s)
        # longestSubString = 0
        # for i in range(n):
        #     charFreqMap = defaultdict(int)
        #     for j in range(i, n):
        #         charFreqMap[s[j]] += 1
        #         if (j - i + 1) - max(charFreqMap.values()) <= k:
        #             longestSubString = max(longestSubString, (j - i + 1))
        #         else:
        #             break
        # return longestSubString


        # N : len(s)
        # Time Complexity: O(N * 26)
        # Space Complexity: O(26)
        # n = len(s)
        # charFreqMap = defaultdict(int)
        # longestSubString = 0
        # l, r = 0, 0
        # while r < n:
        #     charFreqMap[s[r]] += 1
        #     if (r - l + 1) - max(charFreqMap.values()) > k:
        #         charFreqMap[s[l]] -= 1
        #         l += 1
        #     longestSubString = max(longestSubString, (r - l + 1))
        #     r += 1
        # return longestSubString


        # N : len(s)
        # Time Complexity: O(N)
        # Space Complexity: O(26)
        n = len(s)
        charFreqMap = [0] * 26
        longestSubString = 0
        maxCharFreq = 0
        l, r = 0, 0
        while r < n:
            charFreqMap[ord(s[r]) - ord('A')] += 1
            maxCharFreq = max(maxCharFreq, charFreqMap[ord(s[r]) - ord('A')])
            if (r - l + 1) - maxCharFreq > k:
                charFreqMap[ord(s[l]) - ord('A')] -= 1
                l += 1
            longestSubString = max(longestSubString, (r - l + 1))
            r += 1
        return longestSubString