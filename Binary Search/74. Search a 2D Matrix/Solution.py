from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        # M : no of rows of matrix, N : no of cols fo matrix
        # Time Complexity: O(M * N)
        # Space Complexity: O(1)
        # m = len(matrix)
        # n = len(matrix[0])
        # for i in range(m):
        #     for j in range(n):
        #         if matrix[i][j] == target:
        #             return True
        # return False


        # M : no of rows of matrix, N : no of cols fo matrix
        # Time Complexity: O(log(M * N))
        # Space Complexity: O(1)
        m = len(matrix)
        n = len(matrix[0])
        outerLeft, outerRight = 0, m - 1
        while outerLeft <= outerRight:
            outerMid = (outerRight + outerLeft) // 2
            if target < matrix[outerMid][0]:
                outerRight = outerMid - 1
            elif target > matrix[outerMid][n - 1]:
                outerLeft = outerMid + 1
            else:
                innerLeft, innerRight = 0, n - 1
                while innerLeft <= innerRight:
                    innerMid = (innerRight + innerLeft) // 2
                    if target < matrix[outerMid][innerMid]:
                        innerRight = innerMid - 1
                    elif target > matrix[outerMid][innerMid]:
                        innerLeft = innerMid + 1
                    else:
                        return True
                return False
        return False