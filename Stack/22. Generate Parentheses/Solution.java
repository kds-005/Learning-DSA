import java.util.*;

class Solution {
    // private Boolean isValidString(String brackets){
    //     Stack<Character> stack = new Stack<>();
    //     for (Character bracket: brackets.toCharArray()){
    //         if (bracket == '(') stack.push(bracket);
    //         else if (bracket == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
    //         else return false;
    //     }
    //     return stack.isEmpty();
    // }
    // private void backtract(int openPara, int closePara, String brackets, int n, List<String> parentheses){
    //     if (openPara == closePara && closePara == n){
    //         if (isValidString(brackets)) parentheses.add(brackets);
    //         return;
    //     }
    //     if (openPara > n || closePara > n) return;

    //     backtract(openPara + 1, closePara, brackets + '(', n, parentheses);
    //     backtract(openPara, closePara + 1, brackets + ')', n, parentheses);
    //     return;
    // }
    private void backtract(int openPara, int closePara, String brackets, int n, List<String> parentheses){
        if (brackets.length() >= n * 2){
            parentheses.add(brackets);
            return;
        }

        if (openPara < n && closePara <= openPara) backtract(openPara + 1, closePara, brackets + "(", n, parentheses);
        if (closePara < n) backtract(openPara, closePara + 1, brackets + ")", n, parentheses);
        return;
    }
    public List<String> generateParenthesis(int n) {
        // N : n from input
        // Time Complexity: O(2^(2 * N) * N)
        // Space Complexity: O(2N * 2N)
        // List<String> parentheses = new ArrayList<>();
        // backtract(0, 0, "", n, parentheses);
        // return parentheses;


        // N : n from input
        // Time Complexity: O(2^(2 * N)) -> witout constraints but with it will be less
        // Space Complexity: O(2N)
        List<String> parentheses = new ArrayList<>();
        backtract(0, 0, "", n, parentheses);
        return parentheses;
    }
}