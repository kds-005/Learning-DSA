import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        // M: len(s), T: len(t), 26: no of Alphabets
        // Time Complexity: O((M * 26) + N)
        // Space Complexity: O(M + N)
        // int m = s.length();
        // int n = t.length();

        // HashMap<Character, Integer> charFreqT = new HashMap<>();
        // for (int i=0; i<n; i++){
        //     charFreqT.put(t.charAt(i), charFreqT.getOrDefault(t.charAt(i), 0) + 1);
        // }

        // HashMap<Character, Integer> charFreqS = new HashMap<>();
        // int l = 0;
        // int r = 0;
        // int[] res = new int[]{-1, -1};
        // int minLen = Integer.MAX_VALUE;
        // while (r < m){
        //     charFreqS.put(s.charAt(r), charFreqS.getOrDefault(s.charAt(r), 0) + 1);
        //     while (true){
        //         int flag = charFreqT.size();
        //         for(char key: charFreqT.keySet()){
        //             if (charFreqS.containsKey(key) && charFreqT.get(key) <= charFreqS.get(key)) flag--;
        //         }
        //         if (flag == 0){
        //             if ((r - l + 1) < (res[1] - res[0]) || res[1] == -1) res = new int[]{l, r + 1};
        //             charFreqS.put(s.charAt(l), charFreqS.get(s.charAt(l)) - 1);
        //             l++;
        //         } else break;

        //     }
        //     r++;
        // }
        // return (res[0] != -1) ? s.substring(res[0], res[1]) : "";
        



        // M: len(s), T: len(t), 26: no of Alphabets
        // Time Complexity: O(M + N)
        // Space Complexity: O(M + N)
        int m = s.length();
        int n = t.length();
        HashMap<Character, Integer> charFreqT = new HashMap<>();
        for (int i=0; i<n; i++){
            charFreqT.put(t.charAt(i), charFreqT.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> charFreqS = new HashMap<>();
        int l = 0;
        int r = 0;
        int need = charFreqT.size();
        int have = 0;
        int[] res = new int[]{-1, -1};
        while (r < m){
            char charR = s.charAt(r);
            charFreqS.put(charR, charFreqS.getOrDefault(charR, 0) + 1);
            if (charFreqT.containsKey(charR) && charFreqT.get(charR).equals(charFreqS.get(charR))) have++;
            while (need == have){
                char charL = s.charAt(l);
                if ((r - l + 1) < (res[1] - res[0]) || res[1] == -1) res = new int[]{l, r + 1};
                charFreqS.put(charL, charFreqS.get(charL) - 1);
                if (charFreqT.containsKey(charL) && charFreqT.get(charL) > charFreqS.get(charL)) have--;
                l++;
            }
            r++;
        }
        return (res[0] != -1) ? s.substring(res[0], res[1]) : "";
    }
}