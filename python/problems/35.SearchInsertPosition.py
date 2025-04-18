def searchInsert(nums: list[int], target: int) -> int:
    low = 0
    high = len(nums) - 1
    mid = (high + low) // 2
    
    while low <= high:
        mid = (high + low) // 2
        
        if target == nums[mid]:
            return mid
        elif target < nums[mid]:
            high = mid - 1
        elif target > nums[mid]:
            if low == high:
                mid += 1
            low = mid + 1
    return 0 if mid < 0 else mid

print(searchInsert([1,3,5,6], 5)) # 2
print(searchInsert([1,3,5,6], 2)) # 1
print(searchInsert([1,3,5,6], 7)) # 4
print(searchInsert([1,3,5,6], 0)) # 0
print(searchInsert([1,3], 2)) # 1
