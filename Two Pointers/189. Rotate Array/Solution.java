class Solution {
    private void rev(int[] nums, int l, int r){
        while (l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void rotate(int[] nums, int k) {
        // N : len(nums), K: No of rotations as mod of N
        // Time Complexity: O(K + (K * N))
        // Space Complexity: O(1)
        // int n = nums.length;
        // k = k % n;
        // for (int i=0; i<k; i++){
        //     int temp = nums[n - 1];
        //     for (int j=n-2; j>=0; j--){
        //         nums[j + 1] = nums[j];
        //     }
        //     nums[0] = temp;
        // }


        // N : len(nums), K: No of rotations
        // Time Complexity: O(2N)
        // Space Complexity: O(N)
        // int n = nums.length;
        // k = k % n;
        // int[] leftArray = Arrays.copyOfRange(nums, n-k, n);
        // int[] rightArray = Arrays.copyOfRange(nums, 0, n-k);

        // for (int i=0,l=0,r=0; i<n; i++){
        //     if (l < leftArray.length){
        //         nums[i] = leftArray[l];
        //         l++;
        //     } else if (r < rightArray.length){
        //         nums[i]= rightArray[r];
        //         r++;
        //     }
        // }

        // N : len(nums), K: No of rotations
        // Time Complexity: O(2N)
        // Space Complexity: O(1)
        int n = nums.length;
        k = k % n;
        rev(nums, 0, n - 1);
        rev(nums, 0, k - 1);
        rev(nums, k, n - 1);
    }
}