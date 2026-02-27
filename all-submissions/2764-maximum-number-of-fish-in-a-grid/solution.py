class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        if grid is None:
	        return 0

        def dfs(r, c):
            if 0<=r<ROWS and 0<=c<COLS and grid[r][c] != 0 and (r,c) not in seen:
                seen.add((r,c))
                return grid[r][c] + dfs(r, c+1) + dfs(r,c-1) + dfs(r+1,c) + dfs(r-1,c)
            else:
                return 0

        ROWS  = len(grid) 
        COLS = len(grid[0])
        seen = set()
        max_fish = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] !=0 and (r,c) not in seen:
                    curr_fish = dfs(r,c)
                    max_fish = max(max_fish, curr_fish)
        return max_fish

