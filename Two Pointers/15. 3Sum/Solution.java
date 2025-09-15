import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // M: result.length, N: nums.length
        // Time Complexity: O(N logN + N^3 + M)
        // Space Complexity: O(M)
        // int n = nums.length;
        // Arrays.sort(nums);
        // HashSet<List<Integer>> result = new HashSet<>();
        // List<Integer> temp;
        // for (int i=0; i<n; i++){
        //     for (int j=i+1; j<n; j++){
        //         for (int k=j+1 ; k<n; k++){
        //             if (nums[i] + nums[j] + nums[k] == 0){
        //                 temp = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 result.add(temp);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(result);


        // M: result.length, N: nums.length
        // Time Complexity: O(N logN + N^3 + M)
        // Space Complexity: O(M)
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            if (prev == nums[i]){
                prev = nums[i];
                continue;
            }
            prev = nums[i];

            int l = i + 1;
            int r = n - 1;
            while (l < r){
                int summ = nums[i] + nums[l] + nums[r];
                if (summ < 0){
                    l++;
                } else if (summ > 0){
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }
        return result;
    }
}