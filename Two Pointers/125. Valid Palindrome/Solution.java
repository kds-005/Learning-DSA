class Solution {
    public boolean isPalindrome(String s) {
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // StringBuffer str = new StringBuffer();
    
        // for (int i=0; i<s.length(); i++){
        //     char c = Character.toLowerCase(s.charAt(i));
        //     if (Character.isLetterOrDigit(c)){
        //         str.append(c);
        //     }
        // }
        // s = str.toString();
        // String reversedStr = str.reverse().toString();
        // return s.equals(reversedStr);

        
        // Time Complexity: O(N)
        // Space Complexity: O(1)
        int l = 0;
        int r = s.length() - 1;
        while (l < r){
            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));
            if (Character.isLetterOrDigit(left) == false) {
                l++;
                continue;
            }

            if (Character.isLetterOrDigit(right) == false){
                r--;
                continue;
            }
            
            if (left != right) return false;
            l++;
            r--;
        }
        return true;
    }
}