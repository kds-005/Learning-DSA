class Solution {
    private boolean isPalindrome(int l, int r, String s){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        // Time Complexity: O(N^2)
        // Space Complexity: O(1)
        // int n = s.length();
        // boolean flag = true;
        // for (int i=0; i<n; i++){
        //     if (s.charAt(i) != s.charAt(n - i - 1)){
        //         flag = false;
        //         break;
        //     }
        // }
        // if (flag == true) return true;

        // for (int i=0; i<n; i++){
        //     flag = true;
        //     int l = 0;
        //     int r = n - 1;
        //     while (l < r){
        //         if (l == i){
        //             l++;
        //             continue;
        //         }
        //         if (r == i){
        //             r--;
        //             continue;
        //         }
        //         if (s.charAt(l) != s.charAt(r)){
        //             flag = false;
        //             break;
        //         }
        //         l++;
        //         r--;
        //     }

        //     if (flag == true) return true;
        // }
        // return false;



        // Time Complexity: O(2N)
        // Space Complexity: O(1)
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return (isPalindrome(l + 1, r, s) || isPalindrome(l, r - 1, s));
            }
            l++;
            r--;
        }
        return true;
    }
}