from typing import List

class Solution:
    def lexSmallestNegatedPerm(self, n: int, target: int) -> List[int]:
        # N : value of n
        # Time Complexity: O(N logN) -> for sorting
        # Space Complexity: O(N) -> with output array
        summ = (n * (n + 1)) // 2
        if target > summ or target < (summ * -1) or (summ + target) % 2 != 0:
            return []

        sumN = (summ - target) // 2

        res = []
        for num in range(n, 0, -1):
            if num <= sumN:
                sumN -= num
                res.append(-1 * num)
            else:
                res.append(num)
        res.sort()
        return res