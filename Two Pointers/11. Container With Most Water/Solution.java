import java.lang.Math;

class Solution {
    public int maxArea(int[] height) {
        // N : len(height)
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = height.length;
        // int maxWater = 0;
        // for (int i=0; i<n; i++){
        //     for (int j=i+1; j<n; j++){
        //         maxWater = Math.max(maxWater, (j - i) * Math.min(height[i], height[j]));
        //     }
        // }
        // return maxWater;



        // N : len(height)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int maxWater = 0;
        while (l < r){
            maxWater = Math.max(maxWater, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]){
                l++;
            } else{
                r--;
            }
        }
        return maxWater;
    }
}