import java.lang.Math;

class Solution {
    public int trap(int[] height) {
        // N : len(height)
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = height.length;
        // int preMax = 0;
        // int trappedRainWater = 0;
        // for (int l=0; l<n; l++){
        //     int postMax = 0;
        //     for (int r=l; r<n; r++){
        //         postMax = Math.max(postMax, height[r]);
        //     }
        //     preMax = Math.max(preMax, height[l]);
        //     trappedRainWater += Math.min(preMax, postMax) - height[l];
        // }
        // return trappedRainWater;

        

        // N : len(height)
        // Time Complexity: O(3N)
        // Space Complexity: O(2N)
        // int n = height.length;
        
        // int[] preMax = new int[n];
        // int[] postMax = new int[n];
        // preMax[0] = height[0];
        // postMax[n - 1] = height[n - 1];

        // for (int i=1; i<n; i++){
        //     preMax[i] = Math.max(preMax[i - 1], height[i]);
        //     postMax[n - i - 1] = Math.max(height[n - i - 1], postMax[n - i]);
        // }

        // int trappedRainWater = 0;
        // for (int i=0; i<n; i++){
        //     trappedRainWater += Math.min(preMax[i], postMax[i]) - height[i];
        // }
        // return trappedRainWater;


        // N : len(height)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int preMax = height[l];
        int postMax = height[r];
        int trappedRainWater = 0;
        while (l < r){
            if (preMax < postMax){
                l++;
                preMax = Math.max(preMax, height[l]);
                trappedRainWater += preMax - height[l];
            } else{
                r--;
                postMax = Math.max(postMax, height[r]);
                trappedRainWater += postMax - height[r];
            }
        }
        return trappedRainWater;
    }
}