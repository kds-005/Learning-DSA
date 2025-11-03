import guess

class Solution:
    # N : value of n
    # Time Complexity: O(N)
    # Space Complexity: O(1)
    # def guessNumber(self, n: int) -> int:
    #     for i in range(n + 1):
    #         if guess(i) == 0:
    #             return i
    #     return -1


    # N : value of n
    # Time Complexity: O(logN)
    # Space Complexity: O(1)
    def guessNumber(self, n: int) -> int:
        l, r = 0, n
        while l <= r:
            mid = (r + l) // 2
            res = guess(mid)
            if res < 0:
                r = mid - 1
            elif res > 0:
                l = mid + 1
            else:
                return mid
        return -1