from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # M : len(result), N: len(nums)
        # Time Complexity: O(N logN + N^3 + M)
        # Space Complexity: O(M)
        # n = len(nums)
        # nums.sort()
        # result = set()
        # for i in range(n):
        #     for j in range(i + 1, n):
        #         for k in range(j + 1, n):
        #             if nums[i] + nums[j] + nums[k] != 0:
        #                 continue
        #             result.add((nums[i], nums[j], nums[k]))
        # return list(result)


        # M: len(result), N: len(nums)
        # Time Complexity: O(N logN + N^2)
        # Space Complexity: O(M)
        n = len(nums)
        nums.sort()
        result = []
        prevI = float('inf')
        for i in range(n):
            if prevI == nums[i]:
                prevI = nums[i]
                continue
            prevI = nums[i]

            l, r = i + 1, n - 1
            while l < r:
                summ = nums[l] + nums[r] + nums[i]
                if summ < 0:
                    l += 1
                elif summ > 0:
                    r -= 1
                else:
                    result.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and nums[l] == nums[l - 1]:
                        l += 1
        return result