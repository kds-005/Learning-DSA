from typing import List

class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        # N : len(nums), K : k
        # Time Complexity: O(N * K)
        # Space Complexity : O(1)
        # n = len(nums)
        # for i in range(n):
        #     for j in range(i + 1, min(i + k + 1, n)):
        #         if nums[i] == nums[j]:
        #             return True
        # return False


        # N : len(nums), K : k
        # Time Complexity: O(N)
        # Space Complexity : O(K)
        n = len(nums)
        numSet = set()
        l, r = 0, 0
        while r < n:
            if r - l > k:
                numSet.remove(nums[l])
                l += 1
            else:
                if nums[r] in numSet:
                    return True
                numSet.add(nums[r])
                r += 1
        return False