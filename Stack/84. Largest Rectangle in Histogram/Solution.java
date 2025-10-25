import java.util.*;
import java.lang.Math;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // N : len(heights)
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = heights.length;
        // int maxArea = 0;
        // for (int i = 0; i < n; i++) {
        //     int minHeight = heights[i];
        //     for (int j = i; j < n; j++) {
        //         minHeight = Math.min(minHeight, heights[j]);
        //         maxArea = Math.max(maxArea, minHeight * (j - i + 1));
        //     }
        // }
        // return maxArea;


        // N : len(heights)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) { 
                int idx = stack.pop();
                int prev = (stack.isEmpty()) ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[idx] * (i - prev - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int prev = (stack.isEmpty()) ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[idx] * (n - prev - 1));
        }
        return maxArea;
    }
}