from typing import List

class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        # N : len(people)
        # Time Complexity: O(N logN + N)
        # Space Complexity: O(1)
        # n = len(people)
        # people.sort()
        # boatCount = 0
        # l, r = 0, n - 1
        # while l <= r:
        #     boatCount += 1
        #     totalWeight = people[l] + people[r]
        #     if totalWeight > limit:
        #         r -= 1
        #     else:
        #         l += 1
        #         r -= 1
        # return boatCount



        # N : len(people), M : limit
        # Time Complexity: O(N + M + N + M)
        # Space Complexity: O(M)
        n = len(people)
        maxPeople = max(people)
        countPeople = [0] * (maxPeople + 1)
        for p in people:
            countPeople[p] += 1
        l, r = 0, maxPeople
        boatCount = 0
        while l <= r:
            while l <= r and countPeople[l] == 0:
                l += 1
            while l <= r and countPeople[r] == 0:
                r -= 1
            
            if l > r:
                break

            totalWeight = l + r
            if totalWeight > limit:
                boatCount += countPeople[r]
                countPeople[r] = 0
            else:
                boatCount += 1
                if countPeople[r] != 0:
                    countPeople[r] -= 1
                if countPeople[l] != 0:
                    countPeople[l] -= 1
        return boatCount