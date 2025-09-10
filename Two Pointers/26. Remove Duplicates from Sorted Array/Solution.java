class Solution {
    public int removeDuplicates(int[] nums) {
        // Time Complexity: O(N + K)
        // Space Complexity: O(K)
        // ArrayList<Integer> uniqueNums = new ArrayList<>();
        // int prev = Integer.MAX_VALUE;
        // for (int num: nums){
        //     if (num != prev){
        //         uniqueNums.add(num);
        //         prev = num;
        //     }
        // }

        // int k = uniqueNums.size();
        // for(int i=0; i<k; i++){
        //     nums[i] = uniqueNums.get(i);
        // }
        // return k;

        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = nums.length;
        int l = 1;
        int r = 1;
        while (r < n){
            if (nums[r] != nums[r - 1]){
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}