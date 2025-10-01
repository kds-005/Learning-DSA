from collections import deque
from typing import List

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # N : len(arr), K : val of k
        # Time Complexity: O(N)
        # Space Complxity: O(2K)
        # n = len(arr)
        # res = []
        # curr = deque()
        # currSum = 0
        # minDiff = float('inf')
        # for i in range(n):
        #     curr.append(arr[i])
        #     currSum += abs(arr[i] - x)
        #     if len(curr) > k:
        #         val = curr.popleft()
        #         currSum -= abs(val - x)
        #     if len(curr) == k and currSum < minDiff:
        #         minDiff = currSum
        #         res = list(curr)
        # return res


        # N : len(arr), K : val of k
        # Time Complexity: O(Log N + K)
        # Space Complexity: O(K)
        # n = len(arr)
        # def binary_search(target):
        #     l, r = 0, n - 1
        #     while l < r:
        #         mid = (r + l) // 2
        #         if arr[mid] < target:
        #             l = mid + 1
        #         else:
        #             r = mid
        #     return l
        # mid = binary_search(x)
        # mid = mid - 1 if abs(arr[mid - 1] - x) <= abs(arr[mid] - x) and mid - 1 >= 0 else mid
        # l, r = mid, mid
        # while (r - l + 1) < k:
        #     rSum = lSum = float('inf')
        #     if r + 1 < n:
        #         rSum = abs(x - arr[r + 1])
        #     if l - 1 >= 0:
        #         lSum = abs(x - arr[l - 1])
            
        #     if lSum <= rSum:
        #         l -= 1
        #     else:
        #         r += 1
        # return arr[l: r + 1]



        # N : len(arr), K : val of k
        # Time Complexity: O(Log (N - K) + K)
        # Space Complexity: O(K)
        n = len(arr)
        l, r = 0, n - k
        while l < r:
            mid = (r + l) // 2
            if x - arr[mid] > arr[mid + k] - x:
                l = mid + 1
            else:
                r = mid
        return arr[l : l + k]