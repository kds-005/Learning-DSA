from typing import List

class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        # N : len(nums)
        # Time Complexity: O(N^2)
        # Space Complexity: O(N)
        n = len(nums)
        isSorted = False
        count = 0
        while not isSorted:
            isSorted = True
            minSum = [float('inf'), -1]
            for i in range(1, n):
                if nums[i - 1] + nums[i] < minSum[0]:
                    minSum = [nums[i - 1] + nums[i], i - 1]
                if nums[i - 1] > nums[i]:
                    isSorted = False
            temp = []
            if not isSorted:
                if minSum[1] > 0:
                    temp += nums[:minSum[1]]
                temp.append(minSum[0])
                if minSum[1] < n - 2:
                    temp += nums[minSum[1] + 2:]
            nums = temp
            n = len(nums)
            count += 1
        return count - 1