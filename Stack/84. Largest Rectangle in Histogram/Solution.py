from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # N : len(heights)
        # Time Complexity: O(N^2)
        # Space Complexity: O(1)
        # n = len(heights)
        # maxArea = 0
        # for i in range(n):
        #     minHeight = heights[i]
        #     for j in range(i, n):
        #         minHeight = min(minHeight, heights[j])
        #         maxArea = max(maxArea, (j - i + 1) * minHeight)
        # return maxArea


        # N : len(heights)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(heights)
        stack = []
        maxArea = 0
        for i in range(n):
            while stack and heights[stack[-1]] > heights[i]:
                idx = stack.pop()
                prev = -1 if not stack else stack[-1]
                maxArea = max(maxArea, heights[idx] * (i - prev - 1))
            stack.append(i)
        
        while stack:
            idx = stack.pop()
            prev = -1 if not stack else stack[-1]
            maxArea = max(maxArea, heights[idx] * (n - prev - 1))
        return maxArea