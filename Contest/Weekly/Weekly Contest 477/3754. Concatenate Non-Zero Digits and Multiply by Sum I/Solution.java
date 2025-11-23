import java.util.*;

class Solution {
    public long sumAndMultiply(int n) {
        // N: no of digits of 'n'
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        if (n == 0) return n;

        String digitS = Integer.toString(n);
        StringBuilder digitX = new StringBuilder();
        long summ = 0;
        for (int i = 0; i < digitS.length(); i++) {
            if (digitS.charAt(i) == '0') continue;
            summ += Character.getNumericValue(digitS.charAt(i));
            digitX.append(digitS.charAt(i));
        }
        return Long.parseLong(digitX.toString()) * summ;
    }
}