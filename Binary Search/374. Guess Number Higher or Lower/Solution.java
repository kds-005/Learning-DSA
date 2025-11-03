public class Solution extends GuessGame {
    // N : value of n
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    // public int guessNumber(int n) {
    //     for (int num = 0; num <= n; num++) {
    //         if (guess(num) == 0) return num;
    //     }
    //     return -1;
    // }

    // N : value of n
    // Time Complexity: O(logN)
    // Space Complexity: O(1)
    public int guessNumber(int n) {
        long l = 1;
        long r = n;
        while (l <= r) {
            long mid = (r + l) / 2;
            int res = guess((int) mid);
            if (res < 0) r = mid - 1;
            else if (res > 0) l = mid + 1;
            else return (int)mid;
        }
        return -1;
    }
}