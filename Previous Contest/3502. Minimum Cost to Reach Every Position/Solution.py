from typing import List

class Solution:
    def minCosts(self, costs: List[int]) -> List[int]:
        # N : len(cost)
        # Time Complexity: O(N)
        # Space Complexity: O(N) -> with the output arr
        minCostList = []
        for cost in costs:
            cost = min(minCostList[-1], cost) if minCostList else cost
            minCostList.append(cost)
        return minCostList