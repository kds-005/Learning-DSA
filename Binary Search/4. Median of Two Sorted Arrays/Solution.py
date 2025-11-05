from typing import List

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # M : len(nums1), N : len(nums2)
        # Time Complexity: O(M + N)
        # Space Complexity: O(M + N)
        # m = len(nums1)
        # n = len(nums2)
        # res = []
        # l, r = 0, 0
        # while l < m and r < n:
        #     if nums1[l] <= nums2[r]:
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
        
        # if (l + r) % 2 == 0:
        #     return (res[(l + r - 1) // 2] + res[((l + r - 1) // 2) + 1]) / 2
        # else:
        #     return res[(l + r) // 2]


        # M : len(nums1), N : len(nums2)
        # Time Complexity: O(log(M + N))
        # Space Complexity: O(1)
        m, n = len(nums1), len(nums2)
        total = m + n
        half = total // 2
        if m > n:   
            nums1, nums2 = nums2, nums1
            m, n = n, m
        
        l, r = 0, m - 1
        while True:
            mid1 = (r + l) // 2
            mid2 = half - mid1 - 2

            nums1Left = nums1[mid1] if mid1 >= 0 else float('-inf')
            nums1Right = nums1[mid1 + 1] if (mid1 + 1) < m else float('inf')
            nums2Left = nums2[mid2] if mid2 >= 0 else float('-inf')
            nums2Right = nums2[mid2 + 1] if (mid2 + 1) < n else float('inf')

            if nums1Left <= nums2Right and nums2Left <= nums1Right:
                if total % 2 == 0:
                    return (min(nums1Right, nums2Right) + max(nums1Left, nums2Left)) / 2
                else:
                    return min(nums1Right, nums2Right)
            elif nums1Left > nums2Right:
                r = mid1 - 1
            elif nums2Left > nums1Right:
                l = mid1 + 1