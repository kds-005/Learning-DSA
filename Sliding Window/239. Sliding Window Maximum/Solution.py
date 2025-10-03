from collections import deque
import heapq
from typing import List

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        # N : len(nums), K: val of k
        # Time Complexity: O(N * K)
        # Space Complexity: O(N) -> only the Output Array
        # n = len(nums)
        # maxValue = []
        # for i in range(n - k + 1):
        #     maxValue.append(max(nums[i: i + k]))
        # return maxValue


        # N : len(nums), K: val of k
        # Time Complexity: O(N logN)
        # Space Complexity: O(N)
        # n = len(nums)
        # maxValue = []
        # maxHeap = []
        # for i in range(n):
        #     heapq.heappush(maxHeap, [-nums[i], i])
        #     if i + 1 >= k:
        #         while maxHeap[0][1] < (i - k + 1):
        #             heapq.heappop(maxHeap)
        #         maxValue.append(-maxHeap[0][0])
        # return maxValue



        # N : len(nums), K: val of k
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        n = len(nums)
        maxValue = []
        queue = deque()
        l, r = 0, 0
        while r < n:
            while len(queue) > 0 and nums[queue[-1]] < nums[r]:
                queue.pop()
            queue.append(r)

            l = queue[0]
            if (r - l + 1) > k:
                queue.popleft()
                l = queue[0]
            
            if r + 1 >= k:
                maxValue.append(nums[queue[0]])
            r += 1
        return maxValue