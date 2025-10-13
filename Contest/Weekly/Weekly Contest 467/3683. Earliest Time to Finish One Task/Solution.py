from typing import List

class Solution:
    def earliestTime(self, tasks: List[List[int]]) -> int:
        minTask = float('inf')
        for start, time in tasks:
            minTask = min(minTask, start + time)
        return minTask