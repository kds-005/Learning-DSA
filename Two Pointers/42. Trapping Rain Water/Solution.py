from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        # N : len(height)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(height)
        # pre = 0
        # trappedRainWater = 0
        # for l in range(n):
        #     post = 0
        #     for r in range(l, n):
        #         post = max(post, height[r])
        #     pre = max(pre, height[l])
        #     trappedRainWater += min(pre, post) - height[l] 
        # return trappedRainWater

        # N : len(height)
        # Time Complexity: O(3N)
        # Space Complexity: O(2N)
        # n = len(height)
        # pre = height.copy()
        # post = height.copy()
        # for i in range(1, n):
        #     pre[i] = max(pre[i], pre[i - 1])
        #     post[n - i - 1] = max(post[n - i - 1], post[n - i])
        
        # trappedRainWater = 0
        # for i in range(n):
        #     trappedRainWater += min(pre[i], post[i]) - height[i]
        # return trappedRainWater


        # N : len(height)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(height)
        l, r = -1, n
        trappedRainWater = 0
        preMax, postMax = 0, 0
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