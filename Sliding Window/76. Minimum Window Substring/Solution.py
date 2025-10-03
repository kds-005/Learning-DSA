from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # M: len(s), T: len(t), 26: no of Alphabets
        # Time Complexity: O((M * 26) + N)
        # Space Complexity: O(M + N)
        # m = len(s)
        # n = len(t)
        
        # charFreqT = defaultdict(int)
        # for ch in t:
        #     charFreqT[ch] += 1
            
        # charFreqS = defaultdict(int)
        # l, r = 0, 0
        # res = [-1, -1]
        # while r < m:
        #     charFreqS[s[r]] += 1
        #     while True:
        #         flag = len(charFreqT)
        #         for key, val in charFreqT.items():
        #             if key in charFreqS and charFreqS[key] >= val:
        #                 flag -= 1
        #         if flag == 0:
        #             if (r - l + 1) < (res[1] - res[0]) or res[0] == -1:
        #                 res = [l, r + 1]
        #             charFreqS[s[l]] -= 1
        #             l += 1
        #         else:
        #             break
        #     r += 1
        # return s[res[0]:res[1]]


        # M: len(s), T: len(t), 26: no of Alphabets
        # Time Complexity: O(M + N)
        # Space Complexity: O(M + N)
        m = len(s)
        n = len(t)
        
        charFreqT = defaultdict(int)
        for ch in t:
            charFreqT[ch] += 1
            
        charFreqS = defaultdict(int)
        l, r = 0, 0
        res = [-1, -1]
        need, have = len(charFreqT), 0
        while r < m:
            charFreqS[s[r]] += 1
            if s[r] in charFreqT and charFreqT[s[r]] == charFreqS[s[r]]:
                have += 1

            while have == need:
                if (r - l + 1) < (res[1] - res[0]) or res[0] == -1:
                    res = [l, r + 1]
                charFreqS[s[l]] -= 1
                if s[l] in charFreqT and charFreqT[s[l]] > charFreqS[s[l]]:
                    have -= 1
                l += 1
            r += 1
        return s[res[0]:res[1]]