from typing import List

class Solution:
    def splitArray(self, nums: List[int]) -> int:
        n = len(nums)
        preValid = [False] * n
        preValid[0] = True
        preSum = [0] * n
        pre = 0
        for i in range(n):
            if i - 1 >= 0 and nums[i] > nums[i - 1] and preValid[i - 1]:
                preValid[i] = True
            preSum[i] = pre + nums[i]
            pre = preSum[i]

        postValid = [False] * n
        postValid[n-1] = True
        postSum = [0] * n
        post = 0
        for i in range(n-1, -1, -1):
            if i < n - 1 and nums[i] > nums[i + 1] and postValid[i + 1]:
                postValid[i] = True
            postSum[i] = post + nums[i]
            post = postSum[i]

        res = float('inf')
        for i in range(n - 1):
            if preValid[i] and postValid[i+1]:
                res = min(res, abs(preSum[i] - postSum[i + 1]))
        return -1 if res == float('inf') else res