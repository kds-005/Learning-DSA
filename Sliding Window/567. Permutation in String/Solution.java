import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // N : len(s1), M : len(s2)
        // Time Complexity: O(N logN + M * N logN)
        // Space Complexity: O(2N)
        // int n = s1.length();
        // int m = s2.length();
        // char[] s1Array = s1.toCharArray();
        // Arrays.sort(s1Array);

        // for (int i=0; i<m-n+1; i++){
        //     char[] s2Array = s2.substring(i, i + n).toCharArray();
        //     Arrays.sort(s2Array);
        //     if (Arrays.equals(s1Array, s2Array)) return true;
        // }
        // return false;


        // N : len(s1), M : len(s2)
        // Time Complexity: O(M * 26)
        // Space Complexity: O(2 * 26)
        int n = s1.length();
        int m = s2.length();

        int[] s1Map = new int[26];
        for (int i=0; i<n; i++){
            s1Map[s1.charAt(i) - 'a']++;
        }

        int[] s2Map = new int[26];
        int l = 0;
        int r = 0;
        while (r < m){
            s2Map[s2.charAt(r) - 'a']++;
            if ((r - l + 1) > n){
                s2Map[s2.charAt(l) - 'a']--;
                l++;
            }
            if((r - l + 1) == n){
                if (Arrays.equals(s1Map, s2Map)) return true;
            }
            r++;
        }
        return false;
    }
}