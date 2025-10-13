from collections import defaultdict

class Solution:
    def majorityFrequencyGroup(self, s: str) -> str:
        freqMap = defaultdict(int)
        for ch in s:
            freqMap[ch] += 1

        charMap = defaultdict(str)
        maxGroupSize = 0
        maxGroupVal = 0
        for key, val in freqMap.items():
            charMap[val] += key
            if maxGroupSize < len(charMap[val]):
                maxGroupSize = len(charMap[val])
                maxGroupVal = val
            elif maxGroupSize == len(charMap[val]):
                if maxGroupVal < val:
                    maxGroupVal = val
        return charMap[maxGroupVal]