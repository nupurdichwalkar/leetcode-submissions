class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        visited = set()
        ROWS = len(grid)
        COLS = len(grid[0])
        max_area = 0
        def dfs(r, c):
            if (0<=r<ROWS and 0<=c<COLS) and (r,c) not in visited and grid[r][c] == 1:
                visited.add((r,c))
                return 1 + dfs(r+1,c) + dfs(r-1,c) + dfs(r, c+1) + dfs(r, c-1)
            return 0
        for i in range(ROWS):
            for j in range(COLS):
                curr_area = dfs(i,j)
                max_area = max(max_area, curr_area)
        return max_area
