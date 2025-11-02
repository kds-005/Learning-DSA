from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        secNum = 0
        thrNum = 0
        for num in nums:
            if abs(num) > abs(secNum):
                thrNum = secNum
                secNum = num
            elif abs(num) > abs(thrNum):
                thrNum = num
        if secNum <= 0 and thrNum <= 0:
            return secNum * thrNum * (10 ** 5)
        elif secNum >= 0 and thrNum <= 0:
            return secNum * thrNum * -(10 ** 5)
        elif secNum <= 0 and thrNum >= 0:
            return secNum * thrNum * -(10 ** 5)
        elif secNum >= 0 and thrNum >= 0:
            return secNum * thrNum * (10 ** 5)