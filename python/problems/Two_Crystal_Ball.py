'''
The problem
Given two crystal balls that will break if dropped from a high enough distance, determine the exact height in which they will break in the most optimized way.

Case 1: 
    Input: 
        arr = [False, False, False, False, False, True, True, True]
    Output:
        5

Case 2: 
    Input:
        arr = [False, False, False, False, False]
    Output:
        -1

Case 3: 
    Input:
        arr = [True, True, True, True, True, True, True]
    Output:
        0

Case 4: 
    Input:
        arr = [False, False, False, False, False, False, False, True]
    Output:
        7

Case 5: 
    Input:
        arr = [False, False, False, False, True, True, True, True, True, True, True, True, True, True, True, True, True, True]
    Output:
        4
'''
# Two Crystal Ball Problem

import math

def break_height(arr: list[bool]) -> int:
    start = 0
    end = len(arr)
    jump = math.floor(math.sqrt(len(arr)))
    
    for i in range(start, end, jump):
        if(arr[i]):
            if(i == 0):
                return 0
            start = i+1
            break
        
    if start == 0:
        start = len(arr)-1 - jump
        end = len(arr)
    else:
        end = start
        start = start - jump

    for j in range(start, end):
        if(arr[j]):
            return j
            
    return -1
    

arr = [False, False, False, False, False, True, True, True]
print("The ball break at ", break_height(arr)) # 5

arr = [False, False, False, False, False]
print("The ball break at ", break_height(arr)) # -1

arr = [True, True, True, True, True, True, True]
print("The ball break at ", break_height(arr)) # 0

arr = [False, False, False, False, False, False, False, True]
print("The ball break at ", break_height(arr)) # 7

arr = [False, False, False, False, True, True, True, True, True, True, True, True, True, True, True, True, True, True]
print("The ball break at ", break_height(arr)) # 4