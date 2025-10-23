import java.util.*;
import java.lang.Math;

// N : no of elements added to the stack
// Time Complexity; init() - O(1), push() - O(logN), pop() - O(logN)
// Space Complexity ; O(N)
// class FreqStack {

//     private PriorityQueue<int[]> stack;
//     private HashMap<Integer, Integer> count;
//     private int idx;

//     public FreqStack() {
//         stack = new PriorityQueue<>(
//             (a, b) -> {
//                 if (b[0] == a[0]) return Integer.compare(b[1], a[1]);
//                 else return Integer.compare(b[0], a[0]);
//             }
//         );
//         count = new HashMap<>();
//         idx = 0;
//         return;
//     }
    
//     public void push(int val) {
//         idx++;
//         count.put(val, count.getOrDefault(val, 0) + 1);
//         stack.offer(new int[] {count.get(val), idx, val});
//         return;
//     }
    
//     public int pop() {
//         int[] val = stack.poll();
//         count.put(val[2], count.get(val[2]) - 1);
//         return val[2];
//     }
// }



// N : no of elements added to the stack
// Time Complexity; init() - O(1), push() - O(1), pop() - O(1)
// Space Complexity ; O(N)
class FreqStack {

    private HashMap<Integer, Stack<Integer>> mapOfStack;
    private HashMap<Integer, Integer> freq;
    private int maxFreq;

    public FreqStack() {
        mapOfStack = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
        return;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        maxFreq = Math.max(maxFreq, freq.get(val));
        Stack<Integer> tempStack = mapOfStack.getOrDefault(freq.get(val), new Stack<>());
        tempStack.push(val);
        mapOfStack.put(freq.get(val), tempStack);
        return;
    }
    
    public int pop() {
        Stack<Integer> tempStack = mapOfStack.get(maxFreq);
        int val = tempStack.pop();
        mapOfStack.put(maxFreq, tempStack);
        if (tempStack.isEmpty()) maxFreq--;
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}