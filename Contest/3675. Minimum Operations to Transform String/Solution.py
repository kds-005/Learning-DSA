class Solution:
    def minOperations(self, s: str) -> int:
        ls = set(list(s))
        if 'a' in ls and len(ls) == 1:
            return 0
        maxx = 0
        alpha = 'bcdefghijklmnopqrstuvwxyz'
        for st in alpha:
            if st in ls:
                maxx = ord('z') - ord(st)
                break
        return maxx + 1