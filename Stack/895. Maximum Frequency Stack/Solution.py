from collections import defaultdict
import heapq

# N : no of elements added to the stack
# Time Complexity; init() - O(1), push() - O(logN), pop() - O(logN)
# Space Complexity ; O(N)
# class FreqStack:

#     def __init__(self):
#         self.maxStack = []
#         self.count = defaultdict(int)
#         self.idx = 0

#     def push(self, val: int) -> None:
#         self.idx += 1
#         self.count[val] += 1
#         heapq.heappush(self.maxStack, [-self.count[val], -self.idx, val])

#     def pop(self) -> int:
#         val = heapq.heappop(self.maxStack)
#         self.count[val[2]] -= 1
#         return val[2]



# N : no of elements added to the stack
# Time Complexity; init() - O(1), push() - O(1), pop() - O(1)
# Space Complexity ; O(N)
class FreqStack:

    def __init__(self):
        self.freq = defaultdict(int)
        self.mapOfStack = defaultdict(list)
        self.maxFreq = 0

    def push(self, val: int) -> None:
        self.freq[val] += 1
        self.maxFreq = max(self.freq[val], self.maxFreq)
        self.mapOfStack[self.freq[val]].append(val)

    def pop(self) -> int:
        val = self.mapOfStack[self.maxFreq].pop()
        self.freq[val] -= 1
        if len(self.mapOfStack[self.maxFreq]) == 0:
            self.maxFreq -= 1
        return val