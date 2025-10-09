class Solution:
    def romanToInt(self, s: str) -> int:
        # N : len(s)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(s)
        romanNumeralMap = {
            'I': 1, 
            'V': 5, 
            'X': 10, 
            'L': 50,
            'C': 100, 
            'D': 500, 
            'M': 1000
        }
        num = 0
        for i in range(n-1, -1, -1):
            if i < n - 1 and romanNumeralMap[s[i]] < romanNumeralMap[s[i + 1]]:
                num -= romanNumeralMap[s[i]]
            else:
                num += romanNumeralMap[s[i]]
        return num