from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:
        # N : len(height)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(height)
        # maxWater = 0
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         maxWater = max(maxWater, (j - i) * min(height[i], height[j]))
        # return maxWater


        # N : len(height)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(height)
        l, r = 0, n - 1
        maxWater = 0
        while l < r:
            maxWater = max(maxWater, (r - l) * min(height[l], height[r]))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return maxWater