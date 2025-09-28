from typing import List

class Solution:
    def decimalRepresentation(self, n: int) -> List[int]:
        n = str(n)
        res = []
        for i in range(len(n)):
            if n[i] == '0':
                continue
            res.append(int(n[i]) * (10 ** (len(n) - i - 1)))
        return res