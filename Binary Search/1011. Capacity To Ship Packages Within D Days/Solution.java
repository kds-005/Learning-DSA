import java.util.*;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // N : len(weights), M : sum(weights) - max(weights)
        // Time Complexity: O(M * N)
        // Space Complexity: O(1)
        // int n = weights.length;
        // int m = Arrays.stream(weights).max().getAsInt();
        // int s = Arrays.stream(weights).sum();
        // for (int i = m; i <= s; i++) {
        //     int dayCount = 0;
        //     int totalWeight = 0;
        //     boolean flag = true;
        //     for (int weight: weights) {
        //         totalWeight += weight;
        //         if (totalWeight > i) {
        //             totalWeight = weight;
        //             dayCount++;
        //         }
        //         if (dayCount >= days) {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if (flag) return i;
        // }
        // return 0;



        // N : len(weights), M : sum(weights) - max(weights)
        // Time Complexity: O(N * logM)
        // Space Complexity: O(1)
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l <= r) {
            int mid = (r + l) / 2;
            int dayCount = 1;
            int totalWeight = 0;
            for (int weight: weights) {
                totalWeight += weight;
                if (totalWeight > mid) {
                    totalWeight = weight;
                    dayCount++;
                }
            }
            if (dayCount <= days) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}