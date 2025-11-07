import java.lang.Math;

class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        // Time Complexity: O(1)
        // Space Complexity; O(1)
        int totalContainer = Math.min(maxWeight / w, n * n);
        return totalContainer;
    }
}