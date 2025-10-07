import java.util.*;

// N : len(storeQueue), M : len(mainQueue) == 1
// Time Complexity: Creating Object - O(1), push() - O(1), pop() - O(N), top() - O(1), empty() - O(1)
// Space Complexity: O(2N)
// class MyStack {
//     Deque<Integer> mainQueue;
//     Deque<Integer> storeQueue;

//     public MyStack() {
//         mainQueue = new ArrayDeque<>();
//         storeQueue = new ArrayDeque<>();
//     }
    
//     public void push(int x) {
//         mainQueue.offer(x);
//         if (mainQueue.size() > 1){
//             storeQueue.offer(mainQueue.poll());
//         }
//     }
    
//     public int pop() {
//         int n = storeQueue.size();
//         int deletedVal = mainQueue.poll();
//         if (n == 0) return deletedVal;
//         for (int i=0; i<n-1; i++) storeQueue.offer(storeQueue.poll());
//         mainQueue.offer(storeQueue.poll());
//         return deletedVal;
//     }
    
//     public int top() {
//         return mainQueue.peek();
//     }
    
//     public boolean empty() {
//         return mainQueue.isEmpty();
//     }
// }


// M : len(mainQueue)
// Time Complexity: Creating Object - O(1), push() - O(N), pop() - O(1), top() - O(1), empty() - O(1)
// Space Complexity: O(2N)
class MyStack {
    Deque<Integer> mainQueue;

    public MyStack() {
        mainQueue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        mainQueue.offer(x);
        int m = mainQueue.size();
        for (int i=0; i<m-1; i++) mainQueue.offer(mainQueue.poll());
    }
    
    public int pop() {
        return mainQueue.poll();
    }
    
    public int top() {
        return mainQueue.peek();
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}