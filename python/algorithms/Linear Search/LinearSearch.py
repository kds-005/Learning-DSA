# Linear Search
# Time Complexity: O(n)
# Space Complexity: O(1)
# This is a simple linear search algorithm that searches for a target value in a list.
# It is usually used when the list is not sorted
# It iterates through each element in the list and checks if it matches the target value.
# If a match is found, the index of the element is returned. If no match is found, -1 is returned.

def linear_search(arr: list[int], target: int) ->  int:
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

arr = [2,42,1,56,88,12,1]

print("The target element is at " , linear_search(arr, 2))
print("The target element is at " , linear_search(arr, 1))
print("The target element is at " , linear_search(arr, 88))
print("The target element is at " , linear_search(arr, 3))
