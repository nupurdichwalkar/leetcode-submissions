class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        if not grid:
            return -1
        queue = deque()
        visited = set()
        ROWS = len(grid)
        COLS = len(grid[0])
        if k >= ROWS + COLS - 2:
            return ROWS + COLS - 2
        queue.append((0,0,0,k))  #row, col, steps, k
        visited.add((0,0,k))
        directions = [(0,1),(1,0), (-1,0), (0, -1)]
        while queue:
            row, col, steps, obs_count = queue.popleft()
            for dr, dc in directions:
                nr = row+dr
                nc = col+dc
                if 0<=nr<ROWS and 0<=nc<COLS:
                    if (nr, nc) == (ROWS-1, COLS-1):
                        return steps+1
                    else:
                        
                        if grid[nr][nc] == 1 and obs_count > 0 and (nr, nc, obs_count-1) not in visited:
                            visited.add((nr,nc, obs_count-1))
                            queue.append((nr,nc, steps+1, obs_count-1))
                        elif grid[nr][nc] == 0 and (nr, nc, obs_count) not in visited:
                            visited.add((nr,nc, obs_count))
                            queue.append((nr,nc, steps+1, obs_count))

        return -1
