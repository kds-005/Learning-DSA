import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        // HashMap<Integer, Integer> freqMap = new HashMap<>();
        // for (int num: nums){
        //     freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        // }
        // List<Integer> result = new ArrayList<>();
        // for (int key: freqMap.keySet()){
        //     if (freqMap.get(key) > Math.floor(n / 3)){
        //         result.add(key);
        //     }
        // }
        // return result;

        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        for (int num: nums){
            if (num == num1){
                count1++;
            } else if (num == num2){
                count2++;
            } else if (count1 == 0){
                count1 = 1;
                num1 = num;
            } else if (count2 == 0){
                count2 = 1;
                num2 = num;
            } else{
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1 = count2 = 0;
        for (int num: nums){
            if (num == num1){
                count1++;
            } else if (num == num2){
                count2++;
            }
        }

        if (count1 > Math.floor(n / 3)) result.add(num1);
        if (count2 > Math.floor(n / 3)) result.add(num2);
        return result;
    }
}