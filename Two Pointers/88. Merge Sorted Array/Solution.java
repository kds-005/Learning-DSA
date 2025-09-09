class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Time Complexity: O(2(M + N))
        // Space Complexity: O(M + N)
        // int[] result = new int[nums1.length];
        // int l = 0;
        // int r = 0;

        // while (l < m && r < n){
        //     if (nums1[l] < nums2[r]){
        //         result[l + r] = nums1[l];
        //         l++;
        //     } else {
        //         result[l + r] = nums2[r];
        //         r++;
        //     }
        // }

        // while (l < m){
        //     result[l + r] = nums1[l];
        //     l++;
        // }

        // while (r < n){
        //     result[l + r] = nums2[r];
        //     r++;
        // }

        // for (int i=0; i<result.length; i++){
        //     nums1[i] = result[i];
        // }


        // Time Complexity: O(M + N)
        // Space Complexity: O(1)
        int l = m - 1;
        int r = n - 1;
        int fillIdx = nums1.length - 1;

        while (l >= 0 && r >= 0){
            if (nums1[l] > nums2[r]){
                nums1[fillIdx] = nums1[l];
                l--;
            } else {
                nums1[fillIdx] = nums2[r];
                r--;
            }
            fillIdx--;
        }

        while (r >= 0){
            nums1[fillIdx] = nums2[r];
            r--;
            fillIdx--;
        }
    }
}