from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        # N : len(height)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(height)
        # preMax = 0
        # trappedRainWater = 0
        # for l in range(n):
        #     postMax = 0
        #     for r in range(l, n):
        #         postMax = max(postMax, height[r])
        #     preMax = max(preMax, height[l])
        #     trappedRainWater += min(preMax, postMax) - height[l] 
        # return trappedRainWater

        # N : len(height)
        # Time Complexity: O(3N)
        # Space Complexity: O(2N)
        # n = len(height)
        # preMax = height.copy()
        # postMax = height.copy()
        # for i in range(1, n):
        #     preMax[i] = max(preMax[i], preMax[i - 1])
        #     postMax[n - i - 1] = max(postMax[n - i - 1], postMax[n - i])
        
        # trappedRainWater = 0
        # for i in range(n):
        #     trappedRainWater += min(preMax[i], postMax[i]) - height[i]
        # return trappedRainWater


        # N : len(height)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(height)
        l, r = 0, n - 1
        trappedRainWater = 0
        preMax, postMax = height[l], height[r]
        while l < r:
            if preMax < postMax:
                l += 1
                preMax = max(preMax, height[l])
                trappedRainWater += preMax - height[l]
            else:
                r -= 1
                postMax = max(postMax, height[r])
                trappedRainWater += postMax - height[r]
        return trappedRainWater