import java.lang.Math;

class Solution {
    public int findClosest(int x, int y, int z) {
        // Time Compleexity: O(1)
        // Space Complexity: O(1)
        if (Math.abs(z - x) < Math.abs(z - y)) return 1;
        else if (Math.abs(z - x) > Math.abs(z - y)) return 2;
        else return 0;
    }
}