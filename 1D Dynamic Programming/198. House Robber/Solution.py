from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Time Complexity: O(N)
        # Space Complexity: O(N + N)
        # dp = [-1] * (len(nums) + 1)
        # def dfs(i):
        #     if i >= len(nums):
        #         return 0
        #     if dp[i] != -1:
        #         return dp[i]

        #     dp[i] = max(dfs(i + 1),
        #                nums[i] + dfs(i + 2))
        #     return dp[i]

        # return dfs(0)


        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # n = len(nums)
        # dp = [0] * (n + 1)
        # for idx in range(n-1, -1, -1):
        #     take = dp[idx + 2] + nums[idx]
        #     notTake = dp[idx + 1]
        #     dp[idx] = max(take, notTake)
        # return dp[idx]


        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(nums)
        prev1 = prev2 = 0
        for i in range(n-1, -1, -1):
            curr = max(prev1, nums[i] + prev2)
            prev2 = prev1
            prev1 = curr
        return prev1