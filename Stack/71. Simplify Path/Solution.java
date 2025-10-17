import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        // N : len(path)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        // path += "/";
        // int n = path.length();
        // Stack<String> stack = new Stack<>();
        // String curr = "";
        // for (int i = 0; i < n; i++) {
        //     if (path.charAt(i) == '/') {
        //         if (curr.equals("..")) {
        //             if (!stack.isEmpty()) stack.pop();
        //         } else if (!curr.equals("") && !curr.equals(".")) stack.push(curr);
        //         curr = "";
        //     } else curr += path.charAt(i);
        // }
        // return "/" + String.join("/", stack);


        // N : len(path)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        String[] pathComponent = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String curr : pathComponent) {
            if (curr.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!curr.equals("") && !curr.equals(".")) stack.push(curr);
        }
        return "/" + String.join("/", stack);
    }
}