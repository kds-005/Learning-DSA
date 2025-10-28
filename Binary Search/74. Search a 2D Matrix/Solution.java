class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // M : no of rows of matrix, N : no of cols fo matrix
        // Time Complexity: O(M * N)
        // Space Complexity: O(1)
        // int m = matrix.length;
        // int n = matrix[0].length;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == target) return true;
        //     }
        // }
        // return false;


        // M : no of rows of matrix, N : no of cols fo matrix
        // Time Complexity: O(log(M * N))
        // Space Complexity: O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        int outerLeft = 0;
        int outerRight = m - 1;
        while (outerLeft <= outerRight) {
            int outerMid = (outerRight + outerLeft) / 2;
            if (target < matrix[outerMid][0]) outerRight = outerMid - 1;
            else if (target > matrix[outerMid][n - 1]) outerLeft = outerMid + 1;
            else {
                int innerLeft = 0;
                int innerRight = n - 1;
                while (innerLeft <= innerRight) {
                    int innerMid = (innerRight + innerLeft) / 2;
                    if (target < matrix[outerMid][innerMid]) innerRight = innerMid - 1;
                    else if (target > matrix[outerMid][innerMid]) innerLeft = innerMid + 1;
                    else return true;
                }
                return false;
            }
        }
        return false;
    }
}