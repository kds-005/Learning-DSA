from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # N : len(nums), K: No of rotations as mod of N
        # Time Complexity: O(K + (K * N))
        # Space Complexity: O(1)
        # n = len(nums)
        # k = k % n
        # i = 0
        # while i < k:
        #     rotateElement = nums.pop(n - 1)
        #     nums.insert(0, rotateElement)
        #     i += 1

        
        # N : len(nums), K: No of rotations
        # Time Complexity: O(2N)
        # Space Complexity: O(N)
        # n = len(nums)
        # k = k % n
        # swap = nums[n - k:] + nums[:n - k]
        # for i in range(n):
        #     nums[i] = swap[i]



        # N : len(nums), K: No of rotations
        # Time Complexity: O(2N)
        # Space Complexity: O(1)
        n = len(nums)
        k = k % n

        def rev(l, r):  # noqa: E741
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1  # noqa: E741
                r -= 1

        rev(0, n - 1)
        rev(0, k - 1)
        rev(k, n - 1)