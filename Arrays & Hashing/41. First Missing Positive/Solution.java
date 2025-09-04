class Solution {
    public int firstMissingPositive(int[] nums) {
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
        // long maxNum = Arrays.stream(nums).max().getAsInt();
        // for (int i=1; i<(maxNum + 2); i++){
        //     boolean flag = false;
        //     for(int num: nums){
        //         if (num == i){
        //             flag = true;
        //             break;
        //         }
        //     }
        //     if (flag == false){
        //         return i;
        //     }
        // }
        // return 1;

        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // HashSet<Integer> numSet = new HashSet<>();
        // for(int num: nums){
        //     numSet.add(num);
        // }
        
        // long maxNum = Arrays.stream(nums).max().getAsInt();
        // for (int i=1; i<(maxNum + 2); i++){
        //     if (!numSet.contains(i)){
        //         return i;
        //     }
        // }
        // return 1;

        // Time Complexity: O(3n)
        // Space Complexity: O(1)
        int n = nums.length;
        for (int i=0; i<n; i++){
            if (nums[i] > 0) continue;
            nums[i] = n + 2;
        }

        for (int i=0; i<n; i++){
            if (Math.abs(nums[i]) - 1 >= n) continue;
            nums[Math.abs(nums[i]) - 1] = Math.abs(nums[Math.abs(nums[i]) - 1]) * -1;
        }

        for (int i=1; i<n+2; i++){
            if ((i - 1) >= n || nums[i - 1] > 0) return i;;
        }
        return 1;
    }
}