# """
# This is MountainArray's API interface.
# You should not implement it, or speculate about its implementation
# """
#class MountainArray:
#    def get(self, index: int) -> int:
#    def length(self) -> int:
import MountainArray;

class Solution:
    def findInMountainArray(self, target: int, mountainArr: 'MountainArray') -> int:
        # N : len(mountainArr)
        # Time Complexity : O(N)
        # Space Complexity: O(1)
        # n = mountainArr.length()
        # for i in range(n):
        #     if target == mountainArr.get(i):
        #         return i
        # return -1

        
        # N : len(mountainArr)
        # Time Complexity : O(logN)
        # Space Complexity: O(1)
        n = mountainArr.length()
        l, r = 1, n - 2
        peakPos = -1
        while l <= r:
            mid = (r + l) // 2
            left, middle, right = mountainArr.get(mid - 1), mountainArr.get(mid), mountainArr.get(mid + 1)
            if left < middle < right:
                l = mid + 1
            elif left > middle > right:
                r = mid - 1
            elif left < middle > right:
                peakPos = mid
                break
        
        l, r = 0, peakPos - 1
        while l <= r:
            mid = (r + l) // 2
            if target < mountainArr.get(mid):
                r = mid - 1
            elif target > mountainArr.get(mid):
                l = mid + 1
            else:
                return mid
        
        l, r = peakPos, n - 1
        while l <= r:
            mid = (r + l) // 2
            if target < mountainArr.get(mid):
                l = mid + 1
            elif target > mountainArr.get(mid):
                r = mid - 1
            else:
                return mid
        return -1