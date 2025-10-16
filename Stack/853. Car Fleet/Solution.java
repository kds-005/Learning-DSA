import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // N : no of cars
        // Time Complexity: O(N logN)
        // Space Complexity: O(2N)
        // int n = speed.length;
        // int[][] posSpeedPair = new int[n][2];
        // for (int i = 0; i < n; i++){
        //     posSpeedPair[i][0] = position[i];
        //     posSpeedPair[i][1] = speed[i];
        // }
        // Arrays.sort(posSpeedPair, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack<Double> stack = new Stack<>();
        // for (int[] time: posSpeedPair){
        //     Double currTime = (target - time[0]) / (double)time[1];
        //     while (!stack.isEmpty() && stack.peek() <= currTime) stack.pop();
        //     stack.push(currTime);
        // }
        // return stack.size();


        // N : no of cars
        // Time Complexity: O(N logN)
        // Space Complexity: O(N)
        int n = speed.length;
        int[][] posSpeedPair = new int[n][2];
        for (int i = 0; i < n; i++){
            posSpeedPair[i][0] = position[i];
            posSpeedPair[i][1] = speed[i];
        }
        Arrays.sort(posSpeedPair, (a, b) -> Integer.compare(b[0], a[0]));

        int totalFleet = 1;
        double prevTime = (target - posSpeedPair[0][0]) / (double)posSpeedPair[0][1];
        for (int i = 1; i < n; i++){
            Double currTime = (target - posSpeedPair[i][0]) / (double)posSpeedPair[i][1];
            if (currTime > prevTime){
                totalFleet++;
                prevTime = currTime;
            }
        }
        return totalFleet;
    }
}