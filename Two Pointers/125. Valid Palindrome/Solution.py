class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Time Complexity : 0(N)
        # Space Complexity : O(N)
        # res = ''
        # for letter in s:
        #     if letter.isalnum():
        #         res += letter.lower()
        
        # return res == res[::-1]
        
        # Time Complexity : 0(N)
        # Space Complexity : O(1)
        l, r = 0, len(s) - 1

        while l < r:
            left = s[l].lower()
            right = s[r].lower()
            if not left.isalnum():
                l += 1
                continue
            if not right.isalnum():
                r -= 1
                continue
            
            if left != right:
                return False
            l += 1
            r -= 1
        return True