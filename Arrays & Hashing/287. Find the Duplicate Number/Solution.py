class Solution:
    def findDuplicate(self, nums: list[int]) -> int:
        # N : len(nums)
        # Time Complexity: O(N logN)
        # Space Complexity: O(1)
        # n = len(nums)
        # nums.sort()
        # for i in range(1, n):
        #     if nums[i] == nums[i - 1]:
        #         return nums[i]
        # return -1


        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # n = len(nums)
        # freq = [0] * n
        # for num in nums:
        #     if freq[num] == 1:
        #         return num
        #     freq[num] += 1
        # return -1

        # N : len(nums)
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        n = len(nums)
        for i in range(n):
            if nums[abs(nums[i]) - 1] < 0:
                return abs(nums[i])
            nums[abs(nums[i]) - 1] *= -1
        return -1