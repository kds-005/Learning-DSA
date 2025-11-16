import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        // M : len(s), N : len(t)
        // Time Complexity: O(max(MlogM, NlogN))
        // Space Complexity: O(1)
        // char[] sArr = s.toCharArray();
        // char[] tArr = t.toCharArray();
        // Arrays.sort(sArr);
        // Arrays.sort(tArr);
        // return (Arrays.compare(sArr, tArr) == 0) ? true : false;


        // M : len(s), N : len(t)
        // Time Complexity: O(max(M, N))
        // Space Complexity: O(26)
        int m = s.length();
        int n = t.length();
        
        if (m != n) return false;

        int[] sFreq = new int[26];
        for (int i = 0; i < m; i++) sFreq[s.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++) sFreq[t.charAt(i) - 'a']--;

        for (int i = 0; i < 26; i++) {
            if (sFreq[i] != 0) return false;
        }
        return true;
    }
}