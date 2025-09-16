from typing import List

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        # M : len(result), N : len(nums)
        # Time Complexity: O(N logN + N^4 + M)
        # Space Complexity: O(M)
        # n = len(nums)
        # nums.sort()
        # result = set()
        # for a in range(n):
        #     for b in range(a + 1, n):
        #         for c in range(b + 1, n):
        #             for d in range(c + 1, n):
        #                 if nums[a] + nums[b] + nums[c] + nums[d] == target:
        #                     result.add((
        #                         nums[a], 
        #                         nums[b], 
        #                         nums[c], 
        #                         nums[d]
        #                     ))
        # return list(result)


        # M : len(result), N : len(nums)
        # Time Complexity: O(N logN + N^3)
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
            prevJ = float('inf')

            for j in range(i + 1, n):
                if prevJ == nums[j]:
                    prevJ = nums[j]
                    continue
                prevJ = nums[j]

                l, r = j + 1, n - 1
                while l < r:
                    summ = nums[i] + nums[j] + nums[l] + nums[r]
                    if summ < target:
                        l += 1
                    elif summ > target:
                        r -= 1
                    else:
                        result.append([nums[i], nums[j], nums[l], nums[r]])
                        l += 1
                        r -= 1
                        while l < r and nums[l] == nums[l - 1]:
                            l += 1
        return result