from sys import settrace, gettrace
from functools import wraps
import uuid

class trace:
    def __init__(self):
        self.stack_id = []
        pass
    
    def __call__(self, func):
        @wraps(func)
        def wrapper(*args, **kwds):
            print(*args)
            print(**kwds)
            old_trace = None
            result = None
            try:
                old_trace = self._set_trace()
                result = func(*args, **kwds)
            finally:
                self._stop_trace(old_trace)
                
            return result
        return wrapper
    
    def _trace_variable_changes(self, frame, event, arg):
        dataDumps = frame.f_locals
        if event == 'call':
            self.stack_id.append(uuid.uuid4())
            print(dataDumps)
            print(event, frame.f_code.co_name, frame.f_lineno, self.stack_id[-1])
            print()
        if event == 'return':
            child = self.stack_id.pop()
            parent = self.stack_id[-1] if self.stack_id else None
            print(dataDumps)
            print(event, frame.f_code.co_name, frame.f_lineno, "Call:", child, "parent:", parent, "return val:", arg)
            print()
        return self._trace_variable_changes
    
    def _set_trace(self):
        old_trace = gettrace()
        settrace(self._trace_variable_changes)
        return old_trace

    def _stop_trace(self, trace):
        settrace(trace)
        return

    
   
class Solution:
    @trace()
    def stoneGameII(self, piles: list[int]) -> int:
        n = len(piles)
        def dfs(isAlice, idx, maxx):
            if idx == n:
                return 0
            
            res = 0 if isAlice else float('inf')
            total = 0
            for i in range(1, 2 * maxx + 1):
                if idx + i > n:
                    break
                total += piles[idx + i - 1]
                if isAlice:
                    res = max(res, total + dfs(not isAlice, idx + i, max(maxx, i)))
                else:
                    res = min(res, dfs(not isAlice, idx + i, max(maxx, i)))
            return res
        return [dfs(True, 0, 1), "Dhayssa"]

s = Solution()
print(s.stoneGameII([2,7,9,4,4])) # 10
