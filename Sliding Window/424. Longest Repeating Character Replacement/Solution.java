import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        // N : len(s)
        // Time Complexity: O(N^2)
        // Space Complexity: O(26)
        // int n = s.length();
        // int longestSubString = 0;
        // HashMap<Character, Integer> charFreqMap;
        // for (int i=0; i<n; i++){
        //     charFreqMap = new HashMap<>();
        //     for (int j=i; j<n; j++){
        //         charFreqMap.put(s.charAt(j), charFreqMap.getOrDefault(s.charAt(j), 0) + 1);
        //         int maxCharFreq = Collections.max(charFreqMap.values());
        //         if ((j - i + 1) - maxCharFreq <= k) longestSubString = Math.max(longestSubString, (j - i + 1));
        //         else break;
        //     }
        // }
        // return longestSubString;

        
        // N : len(s)
        // Time Complexity: O(N * 26)
        // Space Complexity: O(26)
        // int n = s.length();
        // int longestSubString = 0;
        // HashMap<Character, Integer> charFreqMap = new HashMap<>();
        // int l = 0;
        // int r = 0;
        // while (r < n){
        //     charFreqMap.put(s.charAt(r), charFreqMap.getOrDefault(s.charAt(r), 0) + 1);
        //     int maxCharFreq = Collections.max(charFreqMap.values());
        //     if ((r - l + 1) - maxCharFreq > k){
        //         charFreqMap.put(s.charAt(l), charFreqMap.get(s.charAt(l)) - 1);
        //         l++;
        //     }
        //     longestSubString = Math.max(longestSubString, (r - l + 1));
        //     r++;
        // }
        // return longestSubString;

        // N : len(s)
        // Time Complexity: O(N)
        // Space Complexity: O(26)
        int n = s.length();
        int longestSubString = 0;
        int[] charFreqMap = new int[26];
        int maxCharFreq = 0;
        int l = 0;
        int r = 0;
        while (r < n){
            charFreqMap[s.charAt(r) - 'A']++;
            maxCharFreq = Math.max(maxCharFreq, charFreqMap[s.charAt(r) - 'A']);
            if ((r - l + 1) - maxCharFreq > k){
                charFreqMap[s.charAt(l) - 'A']--;
                l++;
            }
            longestSubString = Math.max(longestSubString, (r - l + 1));
            r++;
        }
        return longestSubString;
    }
}