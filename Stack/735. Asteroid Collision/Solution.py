from typing import List

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        # N : len(asteroids)
        # Time Complexity: O(N)
        # Space Complexity: O(N)
        collisionStack = []
        for asteroid in asteroids:
            while len(collisionStack) > 0 and asteroid < 0 and collisionStack[-1] > 0:
                collisionRes = collisionStack[-1] + asteroid
                if collisionRes > 0:
                    break
                if collisionRes == 0:
                    collisionStack.pop()
                    break
                collisionStack.pop()
            else:
                collisionStack.append(asteroid)
        return collisionStack