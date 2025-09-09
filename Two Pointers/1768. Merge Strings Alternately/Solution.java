class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Time Complexity: O(max(n1, n2))
        // Space Complexity: O(n1 + n2)
        int n1 = word1.length();
        int n2 = word2.length();
        int l = 0;
        int r = 0;

        StringBuilder mergedString = new StringBuilder();
        while (l < n1 && r < n2){
            mergedString.append(word1.charAt(l));
            mergedString.append(word2.charAt(r));
            l++;
            r++;
        }

        while (l < n1){
            mergedString.append(word1.charAt(l));
            l++;
        }

        while (r < n2){
            mergedString.append(word2.charAt(r));
            r++;
        }
        return mergedString.toString();
    }
}