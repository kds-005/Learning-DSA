class Solution:
    # Time Complexity: O(1)
    # Space Complexity: O(1)
    def calculateCost(self, logLen, maxLoad):
        minCost = 0
        if logLen > maxLoad:
            minCost = (logLen - maxLoad) * maxLoad
        return minCost

    def minCuttingCost(self, n: int, m: int, k: int) -> int:
        s = Solution()
        return s.calculateCost(n, k) + s.calculateCost(m, k)