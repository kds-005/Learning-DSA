class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // N : len(temperatures)
        // Time Complexity: O(N^2)
        // Space Complexity: O(N) -> for the output array
        // int n = temperatures.length;
        // int[] answer = new int[n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         if (temperatures[j] <= temperatures[i]) continue;
        //         answer[i] = j - i;
        //         break;
        //     }
        // }
        // return answer;


        // N : len(temperatures)
        // Time Complexity: O(N)
        // Space Complexity: O(2N)
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] tempStack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++){
            while (top >= 0 && temperatures[tempStack[top]] < temperatures[i]) {
                int prevIdx = tempStack[top--];
                answer[prevIdx] = i - prevIdx;
            }
            tempStack[++top] = i;
        }
        return answer;
    }
}