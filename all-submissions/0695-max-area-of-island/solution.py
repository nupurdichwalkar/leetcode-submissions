class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        
        queue = deque()
        visited = set()
        ROWS = len(grid)
        COLS = len(grid[0])
        maxArea = 0
        directions = [(0,1),(1,0), (-1,0), (0,-1)]
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1 and not (r,c) in visited:
                    visited.add((r,c))
                    queue.append((r,c))
                    currArea = 1
                    while queue:
                        row, col = queue.popleft()
                        for dr, dc in directions:
                            nr = row+dr
                            nc = col+dc
                            if 0<=nr<ROWS and 0<=nc<COLS and grid[nr][nc] == 1 and (nr, nc) not in visited:
                                visited.add((nr, nc))
                                currArea+=1
                                queue.append((nr,nc))
                    maxArea = max(maxArea, currArea)

        return maxArea
