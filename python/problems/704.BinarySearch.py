def search(nums: list[int], target: int) -> int:
    low = 0
    high = len(nums)-1
    mid = (high + low) // 2
    
    while low <= high:
        mid = (high + low) // 2
        
        if target == nums[mid]:
            return mid
        elif target < nums[mid]:
            high = mid - 1
        elif target > nums[mid]:
            low = mid + 1
    return -1

print(search([-1, 0, 2, 3, 5, 9, 10], 5)) # 4