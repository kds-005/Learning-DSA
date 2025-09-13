from collections import defaultdict, deque
from typing import List

class Solution:
    def minArrivalsToDiscard(self, arrivals: List[int], w: int, m: int) -> int:
        n = len(arrivals)
        freq = defaultdict(int)
        arr = deque()

        count = 0
        for i in range(n):
            if len(arr) > 0 and ((i + 1) - arr[0][1]) == w:
                freq[arr[0][0]] -= 1
                arr.popleft()
            
            if freq[arrivals[i]] + 1 > m:
                count += 1
            else:
                freq[arrivals[i]] += 1
                arr.append([arrivals[i], i + 1])

        return count