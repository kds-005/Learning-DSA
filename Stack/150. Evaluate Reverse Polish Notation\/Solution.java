import java.util.*;

class Solution {
    private int evalute(int num2, int num1, String operand){
        if (operand.equals("+")) return num1 + num2;
        else if (operand.equals("-")) return num1 - num2;
        else if (operand.equals("*")) return num1 * num2;
        else return num1 / num2;
    }

    private int dfs(Stack<String> tokens, HashSet<String> operands){
        String token = tokens.pop();
        if (!operands.contains(token)) return Integer.parseInt(token);

        int num1 = dfs(tokens, operands);
        int num2 = dfs(tokens, operands);
        return evalute(num1, num2, token);
    }
    public int evalRPN(String[] tokens) {
        // N: len(tokens)
        // Time Complexity: O(N)
        // Space Complexity: O(N) -> Stack Space
        // Stack<String> tokenList = new Stack<>();
        // HashSet<String> operands = new HashSet<>(List.of("+", "-", "*", "/"));
        // tokenList.addAll(Arrays.asList(tokens));
        // return dfs(tokenList, operands);


        // N: len(tokens)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        Stack<Integer> evalStack = new Stack<>();
        HashSet<String> operands = new HashSet<>(List.of("+", "-", "*", "/"));
        
        for (String token: tokens){
            if (!operands.contains(token)) evalStack.push(Integer.parseInt(token));
            else evalStack.push(evalute(evalStack.pop(), evalStack.pop(), token));
        }
        return evalStack.peek();
    }
}