import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        // N : len(operations)
        // Time Complexity: O(2N)
        // Space Complexity: O(N)
        // Stack<Integer> stack = new Stack<>();
        // for (String operation: operations){
        //     if (operation.equals("+")){
        //         stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
        //     } else if (operation.equals("D")){
        //         stack.push(stack.peek() * 2);
        //     } else if (operation.equals("C")){
        //         stack.pop();
        //     } else{
        //         stack.push(Integer.parseInt(operation));
        //     }
        // }
        // return stack.stream().mapToInt(i->i).sum();



        // N : len(operations)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        Stack<Integer> stack = new Stack<>();
        int finalScore = 0;
        for (String operation: operations){
            if (operation.equals("+")){
                stack.push(stack.get(stack.size() - 1) + stack.get(stack.size() - 2));
                finalScore += stack.peek();
            } else if (operation.equals("D")){
                stack.push(stack.peek() * 2);
                finalScore += stack.peek();
            } else if (operation.equals("C")){
                finalScore -= stack.pop();
            } else{
                stack.push(Integer.parseInt(operation));
                finalScore += stack.peek();
            }
        }
        return finalScore;
    }
}