from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # N : len(temperatures)
        # Time Complexity: O(N^2)
        # Space Complexity: O(N) -> for the output array
        # n = len(temperatures)
        # answer = [0] * n
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         if temperatures[j] <= temperatures[i]:
        #             continue
        #         answer[i] = j - i
        #         break
        # return answer


        # N : len(temperatures)
        # Time Complexity: O(N)
        # Space Complexity: O(2N)
        n = len(temperatures)
        answer = [0] * n
        tempStack = []
        
        for i, temp in enumerate(temperatures):
            while len(tempStack) > 0 and temperatures[tempStack[-1]] < temp:
                prevDayIdx = tempStack.pop()
                answer[prevDayIdx] = i - prevDayIdx
            tempStack.append(i)
        return answer