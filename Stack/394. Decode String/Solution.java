import java.util.*;

class Solution {
    public String decodeString(String s) {
        // N : len(s)
        // Time Complexity; O(N)
        // Space Complexity; O(N)
        int n = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < n) {
            if (Character.isDigit(s.charAt(i))) {
                String curr = "";
                while (i < n && Character.isDigit(s.charAt(i))) curr += s.charAt(i++);
                stack.push(curr);
            } else if (Character.isLetter(s.charAt(i))) {
                String curr = "";
                while (i < n && Character.isLetter(s.charAt(i))) curr += s.charAt(i++);
                if (!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0))) curr = stack.pop() + curr;
                stack.push(curr);
            } else if (s.charAt(i) == ']') {
                String curr = stack.pop();
                stack.pop();
                curr = curr.repeat(Integer.parseInt(stack.pop()));
                if (!stack.isEmpty() && Character.isLetter(stack.peek().charAt(0))) curr = stack.pop() + curr;
                stack.push(curr);
                i++;
            } else stack.push(String.valueOf(s.charAt(i++)));
        }
        return stack.peek();
    }
}