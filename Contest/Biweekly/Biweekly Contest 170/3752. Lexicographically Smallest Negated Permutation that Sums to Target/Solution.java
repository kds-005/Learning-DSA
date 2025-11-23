import java.util.*;

class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        // N : value of n
        // Time Complexity: O(N logN) -> for sorting
        // Space Complexity: O(N) -> with output array
        long summ = ((long)n * (n + 1)) / 2;
        if (summ < target || (summ * -1) > target || (target + summ) % 2 != 0) return new int[]{};

        long sumN = (summ - target) / 2;
        int[] res = new int[n];
        int k = 0;
        for (int num = n; num > 0; num--) {
            if (num <= sumN) {
                sumN -= num;
                res[k++] = (num * -1);
            } else res[k++] = num;
        }
        Arrays.sort(res);
        return res;
    }
}