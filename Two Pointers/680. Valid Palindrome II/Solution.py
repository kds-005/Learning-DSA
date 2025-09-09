class Solution:
    def validPalindrome(self, s: str) -> bool:
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(s)
        # flag = True
        # for i in range(n):
        #     if s[i] != s[n - i - 1]:
        #         flag = False
        #         break
        # if flag:
        #     return True

        # for i in range(n):
        #     flag = True
        #     l, r = 0, n - 1
        #     while l < r:
        #         if l == i:
        #             l += 1
        #             continue
        #         if r == i:
        #             r -= 1
        #             continue
        #         if s[l] != s[r]:
        #             flag = False
        #             break
        #         l += 1
        #         r -= 1
        #     if flag:
        #         return True
        # return False
        
        
        # Time Complexity: O(2N)
        # Space Complexity: O(1)
        def isPalindrome(l, r):
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True
        
        l, r = 0, len(s) - 1
        while l < r:
            if s[l] != s[r]:
                return isPalindrome(l + 1, r) or isPalindrome(l, r - 1)
            l += 1
            r -= 1
        return True