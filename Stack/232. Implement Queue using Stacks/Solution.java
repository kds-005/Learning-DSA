import java.util.*;

// N : Total number of elements added
// Time Complexity : Creating MyQueue Object - O(1), push() - O(1), pop() - O(N), peek() - O(N), empty() - O(1)
// Space Complexity : O(N)
// class MyQueue {
//     Stack<Integer> mainStack;
//     Stack<Integer> storeStack;
//     public MyQueue() {
//         mainStack = new Stack<>();
//         storeStack = new Stack<>();
//     }
    
//     public void push(int x) {
//         mainStack.push(x);
//     }
    
//     public int pop() {
//         int n = mainStack.size();
//         int deletedVal = -1;
//         for (int i=0; i<n; i++){
//             deletedVal = mainStack.pop();
//             if (i == n - 1) continue;
//             storeStack.push(deletedVal);
//         }

//         while (!storeStack.isEmpty()) mainStack.push(storeStack.pop());
//         return deletedVal;
//     }
    
//     public int peek() {
//         int n = mainStack.size();
//         int deletedVal = -1;
//         for (int i=0; i<n; i++){
//             deletedVal = mainStack.pop();
//             storeStack.push(deletedVal);
//         }

//         while (!storeStack.isEmpty()) mainStack.push(storeStack.pop());
//         return deletedVal;
//     }
    
//     public boolean empty() {
//         return mainStack.isEmpty();
//     }
// }


// N : Total number of elements added
// Time Complexity : Creating MyQueue Object - O(1), push() - O(1), pop() - O(1), peek() - O(1), empty() - O(1)
// Space Complexity : O(N)
class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    
    public int pop() {
        int m = popStack.size();
        if (m == 0){
            while (!pushStack.isEmpty()) popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }
    
    public int peek() {
        int m = popStack.size();
        if (m == 0){
            while (!pushStack.isEmpty()) popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }
    
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
