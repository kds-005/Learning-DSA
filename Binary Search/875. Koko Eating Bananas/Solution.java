import java.lang.Math;
import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // N : len(piles), M : max(piles)
        // Time Complexity: O(N * M)
        // Space Complexity: O(1)
        // int m = Arrays.stream(piles).max().getAsInt();
        // for (int banana = 1; banana <= m; banana++) {
        //     double totalHour = 0;
        //     for (int pile: piles) totalHour += Math.ceil((double) pile / banana);
        //     if (totalHour <= h) return banana;
        // }
        // return 0;


        // N : len(piles), M : max(piles)
        // Time Complexity: O(N * logM)
        // Space Complexity: O(1)
        int l = 0;
        int r = 0;
        for (int pile: piles) r = Math.max(pile, r);
        while (l <= r) {
            int banana = (r + l) / 2;
            long totalHour = 0;
            for (int pile: piles) totalHour += Math.ceil((double)pile / banana);
            if (totalHour > h) l = banana + 1;
            else r = banana - 1;
        }
        return l;
    }
}