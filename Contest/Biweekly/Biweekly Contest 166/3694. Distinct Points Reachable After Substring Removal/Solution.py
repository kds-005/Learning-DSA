class Solution:
    def distinctPoints(self, s: str, k: int) -> int:
        n = len(s)
        dir = {'U': [0, 1], 'D' : [0, -1], 'L' : [-1, 0], 'R' : [1, 0]}
        
        pre = [(0, 0)] * (n + 1)
        for i, move in enumerate(s):
            pre[i + 1] = (pre[i][0] + dir[s[i]][0], pre[i][1] + dir[s[i]][1])

        post = [(0, 0)] * (n + 1)
        for i in range(n-1, -1, -1):
            post[i] = (post[i + 1][0] + dir[s[i]][0], post[i + 1][1] + dir[s[i]][1])

        distinct = set()
        for i in range(n - k + 1):
            distinct.add((pre[i][0] + post[i + k][0], pre[i][1] + post[i + k][1]))
        return len(distinct)