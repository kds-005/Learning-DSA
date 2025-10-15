import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // N : len(asteroids)
        // Time Complexity: O(N)
        // Space Complexity: O(N)
        int n = asteroids.length;
        int[] collisionStack = new int[n];
        int top = -1;

        for (int asteroid: asteroids){
            boolean flag = true;
            while (top >= 0 && asteroid < 0 && collisionStack[top] > 0){
                int collisionRes = collisionStack[top] + asteroid;
                if (collisionRes > 0) {
                    flag = false;
                    break;
                }
                if (collisionRes == 0){
                    flag = false;
                    --top;
                    break;
                }
                --top;
            }
            if (flag) {
                collisionStack[++top] = asteroid;
            }
        }
        return Arrays.copyOfRange(collisionStack, 0, top + 1);
    }
}