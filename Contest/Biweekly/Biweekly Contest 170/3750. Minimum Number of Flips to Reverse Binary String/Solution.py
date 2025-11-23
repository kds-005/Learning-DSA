class Solution:
    def minimumFlips(self, n: int) -> int:
        # N : len of binary representaion of the 'n'
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        binS = bin(n)[2:]
        n = len(binS)

        minFlips = 0
        l, r = 0, n - 1
        while l < r:
            if binS[l] != binS[r]:
                minFlips += 2
            l += 1
            r -= 1
        return minFlips