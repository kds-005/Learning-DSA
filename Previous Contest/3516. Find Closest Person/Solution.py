class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        # Time Compleexity: O(1)
        # Space Complexity: O(1)
        if abs(z - x) < abs(z - y):
            return 1
        elif abs(z - x) > abs(z - y):
            return 2
        else:
            return 0