class Solution:
    def removeZeros(self, n: int) -> int:
        n = str(n)
        res = ''
        for i in range(len(n)):
            res += n[i] if n[i] != '0' else ''
        return int(res)