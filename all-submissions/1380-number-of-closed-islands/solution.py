class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        ROWS = len(grid)
        COLS = len(grid[0])
        visit = set()
        closed_islands = 0

        def valid(r, c):
            return 0<=r<ROWS and 0<=c<COLS

        def bfs(row, col):
            visit.add((row, col))
            queue = collections.deque()
            queue.append((row, col))
            directions = [(0,1),(0,-1),(1,0),(-1,0)]
            is_closed = True
            while queue:
                row, col = queue.popleft()
                for dr,dc in directions:
                    nr = dr+row
                    nc = dc+col
                    if not valid(nr, nc):
                        is_closed = False
                    elif valid(nr, nc) and (nr, nc) not in visit and grid[nr][nc] == 0:
                        visit.add((nr, nc))
                        queue.append((nr, nc))
            return is_closed

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 0 and (r,c) not in visit and bfs(r,c):
                    closed_islands +=1
        return closed_islands
