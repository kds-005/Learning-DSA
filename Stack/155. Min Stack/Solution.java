import java.util.*;
import java.lang.Math;

// N : no of elements in a stack
// Time Complexity : Creating MinStack Object - O(1), push() - O(1), pop() - O(1), top() - O(1), getMin() - O(N)
// Space Complexity : O(N)
// class MinStack {
//     Stack<Integer> stack;

//     public MinStack() {
//         stack = new Stack<>();
//     }
    
//     public void push(int val) {
//         stack.push(val);
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return stack.stream().min((a, b)->a.compareTo(b)).orElse(Integer.MAX_VALUE);
//     }
// }



// N : no of elements in a stack
// Time Complexity : Creating MinStack Object - O(1), push() - O(1), pop() - O(1), top() - O(1), getMin() - O(1)
// Space Complexity : O(N)
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty()) minStack.push(val);
        else minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}