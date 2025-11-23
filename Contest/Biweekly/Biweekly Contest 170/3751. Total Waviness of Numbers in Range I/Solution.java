import java.util.*;

class Solution {
    public int totalWaviness(int num1, int num2) {
        // N : no of number btw num1 and num2, M : no of digits
        // Time Complexity: O(N * M)
        // Space Complexity: O(M)
        int totalWav = 0;
        for (int num = num1; num <= num2; num++) {
            String numStr = Integer.toString(num);
            for (int i = 1; i < numStr.length() - 1; i++) {
                if ((Character.getNumericValue(numStr.charAt(i)) < Character.getNumericValue(numStr.charAt(i - 1)) && 
                Character.getNumericValue(numStr.charAt(i)) < Character.getNumericValue(numStr.charAt(i + 1))) || 
                (Character.getNumericValue(numStr.charAt(i)) > Character.getNumericValue(numStr.charAt(i - 1)) && 
                Character.getNumericValue(numStr.charAt(i)) > Character.getNumericValue(numStr.charAt(i + 1)))) {
                    totalWav++;
                }
            }
        }
        return totalWav;
    }
}