from typing import List

class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        # n = len(nums)
        # dp = [-1] * (target + 1)
        # def dfs(total):
        #     if total == 0:
        #         return 1
        #     if total < 0:
        #         return 0
        #     if dp[total] != -1:
        #         return dp[total]
            
        #     res = 0
        #     for num in nums:
        #         if total - num < 0:
        #             continue
        #         res += dfs(total - num)
        #     dp[total] = res
        #     return dp[total]
        # return dfs(target)

        dp = [0] * (target + 1)
        dp[0] = 1
        for total in range(1, target + 1):
            res = 0
            for num in nums:
                if total < num:
                    continue
                res += dp[total - num]
            dp[total] = res
        return dp[target]