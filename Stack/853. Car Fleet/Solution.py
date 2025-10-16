from typing import List

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        # N : no of cars
        # Time Complexity: O(N logN)
        # Space Complexity: O(2N)
        # n = len(speed)
        # time = [(position[i], speed[i]) for i in range(n)]
        # time.sort(key = lambda x: x[0])
        
        # stack = []
        # for pos, speed in time:
        #     req_time = (target - pos) / speed
        #     while len(stack) > 0 and stack[-1] <= req_time:
        #         stack.pop()
        #     stack.append(req_time)
        # return len(stack)


        # N : no of cars
        # Time Complexity: O(N logN)
        # Space Complexity: O(N)
        n = len(speed)
        time = [(position[i], speed[i]) for i in range(n)]
        time.sort(key = lambda x: x[0], reverse = True)
        
        totalFleet = 1
        prevReqTime = (target - time[0][0]) / time[0][1]
        for pos, speed in time[1:]:
            currReqTime = (target - pos) / speed
            if currReqTime > prevReqTime:
                totalFleet += 1
                prevReqTime = currReqTime
        return totalFleet