class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        directions = [(2,1),(-2,1),(2,-1),(1,2),(1,-2),(-1,2)]
        x = abs(x)
        y = abs(y)
        if (x,y) == (0,0):
            return 0
        queue = deque()
        queue.append((0,0,0))
        visited = set()
        visited.add((0,0))
        while(queue):
            r, c, moves = queue.popleft()
            if (r,c)  == (x,y):
                return moves
            for cx, cy in directions:
                next_r = r + cx
                next_c = c + cy
                if (next_r, next_c) not in visited and -1 <= next_r <= x+2 and  -1 <= next_c <= y+2:
                    visited.add((next_r, next_c))
                    queue.append((next_r, next_c,moves+1))
        return -1
