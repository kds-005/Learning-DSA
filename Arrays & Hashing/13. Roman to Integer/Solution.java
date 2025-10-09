import java.util.*;

class Solution {
    public int romanToInt(String s) {
        // N : len(s)
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int n = s.length();
        HashMap<Character, Integer> romanMap = new HashMap<>(Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        ));
        int num = 0;
        for(int i=n-1; i>=0; i--){
            if (i < n - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))){
                num -= romanMap.get(s.charAt(i));
            } else{
                num += romanMap.get(s.charAt(i));
            } 
        }
        return num;
    }
}