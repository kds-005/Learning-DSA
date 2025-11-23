import java.util.*;

class Solution {
    public int minimumFlips(int n) {
        // N : len of binary representaion of the 'n'
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        String binS = Integer.toBinaryString(n);
        int m = binS.length();
        int l = 0;
        int r = m - 1;
        int totalFlips = 0;
        while (l < r) {
            if (binS.charAt(l) != binS.charAt(r)) {
                totalFlips += 2;
            }
            l++;
            r--;
        }
        return totalFlips;
    }
}