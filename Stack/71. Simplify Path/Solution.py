class Solution:
    def simplifyPath(self, path: str) -> str:
        # N : len(path)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        # path += '/'
        # n = len(path)
        # stack = []
        # curr = ''
        # for i in range(n):
        #     if path[i] == '/':
        #         if curr == '..':
        #             if len(stack) > 0:
        #                 stack.pop()
        #         elif curr != '' and curr != '.':
        #             stack.append(curr)
        #         curr = ''
        #     else:
        #         curr += path[i]
        # return '/' + '/'.join(stack)


        # N : len(path)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        path = path.split("/")
        n = len(path)
        stack = []
        for i in range(n):
            if path[i] == '..':
                if len(stack) > 0:
                    stack.pop() 
            elif path[i] != '' and path[i] != '.':
                stack.append(path[i])
        return '/' + '/'.join(stack)