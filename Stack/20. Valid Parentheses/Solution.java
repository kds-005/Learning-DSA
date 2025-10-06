import java.util.*;

class Solution {
    public boolean isValid(String s) {
        // N : len(s)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // int n = s.length();
        // Stack<Character> stack = new Stack<>();
        // for (char ch: s.toCharArray()){
        //     if (ch == ')' && !stack.empty() && stack.peek() == '(') stack.pop();
        //     else if (ch == '}' && !stack.empty() && stack.peek() == '{') stack.pop();
        //     else if (ch == ']' && !stack.empty() && stack.peek() == '[') stack.pop();
        //     else stack.push(ch);
        // }
        // return stack.empty() ? true : false;


        // N : len(s)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = s.length();
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()){
            if (!bracketMap.containsKey(ch)){
                stack.push(ch);
                continue;
            }
            if (stack.empty() || stack.peek() != bracketMap.get(ch)) return false;
            stack.pop();
        }
        return stack.empty() ? true : false;
    }
}