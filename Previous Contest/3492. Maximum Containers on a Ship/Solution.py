class Solution:
    def maxContainers(self, n: int, w: int, maxWeight: int) -> int:
        # Time Complexity: O(1)
        # Space Complexity: O(1)
        totalContainer = min(maxWeight // w, n * n)
        return totalContainer