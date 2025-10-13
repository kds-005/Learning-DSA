from typing import List

class Solution:
    def subsequenceSumAfterCapping(self, nums: List[int], k: int) -> List[bool]:
        n = len(nums)
        nums.sort()
        def dfs(idx, total, cap):
            if total == 0:
                return True
            if total < 0:
                return False
            if idx >= n:
                return False
            
            if (idx, total) in dp:
                return dp[(idx, total)]
            
            for i in range(idx + 1, n):
                num = min(nums[i], cap)
                if dfs(i, total - num, cap):
                    dp[(idx, total)] = True
                    return dp[(idx, total)]
            dp[(idx, total)] = False
            return dp[(idx, total)]
        
        result = []
        for i in range(1, n + 1):
            dp = {}
            result.append(dfs(-1, k, i))
        return result