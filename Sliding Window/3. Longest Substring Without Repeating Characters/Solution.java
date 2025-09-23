import java.lang.Math;
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // N : len(s), M : Longest unique SubString
        // Time Complexity: O(N^2)
        // Space Complexity: O(M)
        // int n = s.length();
        // HashSet<Character> charSet = new HashSet<>();
        // int longestString = 0;
        // for (int i=0; i<n; i++){
        //     charSet = new HashSet<>();
        //     for (int j=i; j<n; j++){
        //         if (charSet.contains(s.charAt(j))){
        //             longestString = Math.max(longestString, j - i);
        //             break;
        //         }
        //         charSet.add(s.charAt(j));
        //     }
        //     longestString = Math.max(longestString, charSet.size());
        // }
        // return longestString;


        // N : len(s), M : Longest unique SubString
        // Time Complexity: O(N)
        // Space Complexity: O(M)
        int n = s.length();
        HashSet<Character> charSet = new HashSet<>();
        int longestString = 0;
        int l = 0;
        int r = 0;
        while (r < n){
            if (charSet.contains(s.charAt(r))){
                longestString = Math.max(longestString, r - l);
                charSet.remove(s.charAt(l));
                l++;
                continue;
            }
            charSet.add(s.charAt(r));
            r++;
        }
        return longestString = Math.max(longestString, r - l);
    }
}