class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        
        def isValid(freqCount):
            maxFreqCount = float('-inf')
            minFreqCount = float('inf')
            for count in freqCount:
                if count == 0:
                    continue
                maxFreqCount = max(maxFreqCount, count)
                minFreqCount = min(minFreqCount, count)
            return maxFreqCount == minFreqCount
            
        l, r = 0, 0
        longestSub = 0
        freqCount = [0] * (26)
        flag = True
        while r < n:
            if flag:
                freqCount[ord(s[r]) - ord('a')] += 1
            if isValid(freqCount):
                longestSub = max(longestSub, (r - l + 1))
            
            r += 1
            if r == n:
                freqCount[ord(s[l]) - ord('a')] -= 1
                l += 1
                while r > l + longestSub:
                    flag = False
                    if r < n:
                        freqCount[ord(s[r]) - ord('a')] -= 1
                    r -= 1
            else:
                flag = True
        return longestSub