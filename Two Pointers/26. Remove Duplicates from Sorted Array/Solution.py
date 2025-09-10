from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # Time Complexity: O(N + K)
        # Space Complexity: O(K)
        # uniqueNums = []
        # prev = float('inf')
        # for num in nums:
        #     if prev != num:
        #         uniqueNums.append(num)
        #         prev = num
        
        # k = len(uniqueNums)
        # for i in range(k):
        #     nums[i] = uniqueNums[i]
        # return k


        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(nums)
        l, r = 1, 1
        while r < n:
            if nums[r] != nums[r - 1]:
                nums[l] = nums[r]
                l += 1
            r += 1
        return l