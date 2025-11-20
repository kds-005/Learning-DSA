from typing import List

class Solution:
    def maximizeExpressionOfThree(self, nums: List[int]) -> int:
        # N : len(nums)
        # Time Complexity: O(N^3)
        # Space Complexity: O(1)
        # n = len(nums)
        # maxExp = float('-inf')
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         for k in range(j + 1, n):
        #             maxExp = max(maxExp, (nums[i] + nums[j] - nums[k]))
        #             maxExp = max(maxExp, (nums[i] + nums[k] - nums[j]))
        #             maxExp = max(maxExp, (nums[k] + nums[j] - nums[i]))
        # return maxExp

        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(nums)
        
        firstBig = smallest = nums[0]
        secondBig = float('-inf')
        for i in range(1, n):
            smallest = min(smallest, nums[i])
            if firstBig < nums[i]:
                secondBig = firstBig
                firstBig =  nums[i]
            elif secondBig < nums[i]:
                secondBig = nums[i]
        return firstBig + secondBig - smallest