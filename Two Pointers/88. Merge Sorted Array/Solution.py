from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # Time Complexity: O(2(M + N))
        # Space Complexity: O(M + N)
        # l = r = 0
        # res = []
        # while l < m and r < n:
        #     if nums1[l] < nums2[r]:
        #         res.append(nums1[l])
        #         l += 1
        #     else:
        #         res.append(nums2[r])
        #         r += 1
        
        # while l < m:
        #     res.append(nums1[l])
        #     l += 1
        
        # while r < n:
        #     res.append(nums2[r])
        #     r += 1
        
        # for i in range(len(res)):
        #     nums1[i] = res[i]


        # Time Complexity: O(M + N)
        # Space Complexity: O(1)
        l = m - 1
        r = n - 1
        fillIdx = len(nums1) - 1
        while l >= 0 and r >= 0:
            if nums1[l] > nums2[r]:
                nums1[fillIdx] = nums1[l]
                l -= 1
            else:
                nums1[fillIdx] = nums2[r]
                r -= 1
            fillIdx -= 1
        
        while r >= 0:
            nums1[fillIdx] = nums2[r]
            r -= 1
            fillIdx -= 1