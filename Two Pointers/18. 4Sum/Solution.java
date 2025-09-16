import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // M : len(result), N : len(nums)
        // Time Complexity: O(N logN + N^4 + M)
        // Space Complexity: O(M)
        // int n = nums.length;
        // Arrays.sort(nums);
        // Set<List<Integer>> result = new HashSet<>();
        // for (int a=0; a<n; a++){
        //     for (int b=a+1; b<n; b++){
        //         for (int c=b+1; c<n; c++){
        //             for (int d=c+1; d<n; d++){
        //                 int summ = nums[a] + nums[b] + nums[c] + nums[d];
        //                 if (summ != target) continue;
        //                 List<Integer> temp = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
        //                 result.add(temp);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(result);


        // M : len(result), N : len(nums)
        // Time Complexity: O(N logN + N^3)
        // Space Complexity: O(M)
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int prevI = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            if (prevI == nums[i]){
                prevI = nums[i];
                continue;
            }
            prevI = nums[i];
            int prevJ = Integer.MIN_VALUE;
            for (int j=i+1; j<n; j++){
                if (prevJ == nums[j]){
                    prevJ = nums[j];
                    continue;
                }
                prevJ = nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r){
                    long summ = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];
                    if (summ < target){
                        l++;
                    } else if (summ > target){
                        r--;
                    } else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                    }
                }
            }
        }
        return result;
    }
}