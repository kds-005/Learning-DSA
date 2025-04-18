def missingNumber(nums: list[int]) -> int:
    n = len(nums)
    sum = 0
    for num in nums:
        sum += num    
    return ((n*(n+1))//2) - sum

print(missingNumber([3,0,1])) # 2
print(missingNumber([0,1])) # 2
print(missingNumber([9,6,4,2,3,5,7,0,1])) # 8