# N : number of timestamp of a particlar key, M : number of keys
# Time Complexity: init() - O(1), set() - O(1), get - O(N)
# Space Complexity: O(M * N)
# class TimeMap:
#     def __init__(self):
#         self.store = {}

#     def set(self, key: str, value: str, timestamp: int) -> None:
#         if key not in self.store:
#             self.store[key] = []
#         self.store[key].append([timestamp, value])

#     def get(self, key: str, timestamp: int) -> str:
#         res = ""
#         if key in self.store:
#             for time, val in self.store[key]:
#                 if time > timestamp:
#                     return res
#                 res = val
#         return res


# N : number of timestamp of a particlar key, M : number of keys
# Time Complexity: init() - O(1), set() - O(1), get - O(logN)
# Space Complexity: O(M * N)
class TimeMap:
    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        res = [float('inf'), ""]
        if key in self.store:
            n = len(self.store[key])
            l, r = 0, n - 1
            while l <= r:
                mid = (r + l) // 2
                if self.store[key][mid][0] < timestamp:
                    l = mid + 1
                elif self.store[key][mid][0] > timestamp:
                    r = mid - 1
                else:
                    return self.store[key][mid][1]
            res = self.store[key][r]
        
        return res[1] if res[0] < timestamp else ""