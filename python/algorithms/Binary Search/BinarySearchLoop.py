# Iterative Binary Search
# Time complexity: O(log n)
# Space complexity: O(1)
# It finds the index of a target value in a sorted array.
# If the target is not found, it returns -1.
# If the target is found, it returns the index of the target in the array.
# If the target is less than the middle element, it searches the left half of the array.
# If the target is greater than the middle element, it searches the right half of the array.
# It repeats this process until the target is found or the search space is empty.

def binary_search(arr: list[int], target: int) -> int:
    mid = len(arr) // 2
    upper = len(arr) - 1
    lower = 0
    
    for i in range(upper+1):
        if target == arr[mid]:
            return mid
        elif target < arr[mid]:
            upper = mid - 1
            mid = (lower + upper) // 2
        elif target > arr[mid]:
            lower = mid + 1
            mid = (lower + upper) // 2
        
        if lower > upper:
            return -1
            
arr = [1,2,3,4,5,6,7,8,9,12,24,34,56,67,68]

print("The target element is at " , binary_search(arr, 1)) # 0
print("The target element is at " , binary_search(arr, 12)) # 9
print("The target element is at " , binary_search(arr, 56)) # 12
print("The target element is at " , binary_search(arr, 3)) # 2
print("The target element is at " , binary_search(arr, 99)) # -1