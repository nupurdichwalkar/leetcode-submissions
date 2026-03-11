class Solution:
    def getFood(self, grid: List[List[str]]) -> int:
        if not grid:
            return -1
        
        queue = deque()
        visited = set()
        ROWS = len(grid)
        COLS = len(grid[0])
        ans = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == "*":
                    queue.append((r,c, 0))
                    visited.add((r,c))
        directions = [(0,1),(1,0), (-1,0), (0, -1)]
        while queue:
            row, col, steps = queue.popleft()
            for dr, dc in directions:
                nr = row+dr
                nc = col+dc
                if 0<=nr<ROWS and 0<=nc<COLS and grid[nr][nc] != "X" and (nr,nc) not in visited:
                    if grid[nr][nc] == "#":
                        return steps+1
                    else:
                        visited.add((nr,nc))
                        queue.append((nr,nc, steps+1))
        return -1
        
