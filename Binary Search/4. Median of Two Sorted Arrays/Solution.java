import java.util.*;
import java.lang.Math;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // M : len(nums1), N : len(nums2)
        // Time Complexity: O(M + N)
        // Space Complexity: O(M + N)
        // int m = nums1.length;
        // int n = nums2.length;
        // List<Integer> res = new ArrayList<>();
        // int l = 0;
        // int r = 0;
        // while (l < m && r < n) {
        //     if (nums1[l] < nums2[r]) res.add(nums1[l++]);
        //     else res.add(nums2[r++]);
        // }
        // while (l < m) res.add(nums1[l++]);
        // while (r < n) res.add(nums2[r++]);
        
        // if ((l + r) % 2 == 0) {
        //     return ((float) res.get((l + r - 1) / 2) + res.get((l + r) / 2)) / 2;
        // } else {
        //     return res.get((l + r - 1) / 2);
        // }

        // M : len(nums1), N : len(nums2)
        // Time Complexity: O(log(M + N))
        // Space Complexity: O(1)
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;
        
        int total = m + n;
        int half = total / 2;
        int l = 0;
        int r = m;

        while (l <= r) {
            int mid1 = (r + l) / 2;
            int mid2 = half - mid1;
            
            int nums1Left = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int nums1Right = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
            int nums2Left = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int nums2Right = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (total % 2 == 0) {
                    return ((double) Math.min(nums1Right, nums2Right) + Math.max(nums1Left, nums2Left)) / 2;
                } else {
                    return Math.min(nums1Right, nums2Right);
                }
            } else if (nums1Left > nums2Right) r = mid1 - 1;
            else l = mid1 + 1;
        }
        return -1;
    }
}