class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def isValid(row, col):
            return 0<=row<len(grid) and 0<=col<len(grid[0]) and grid[row][col] == "1"
	
        def dfs(row, col):
            if (isValid(row, col) and (row, col) not in seen):			
                seen.add((row, col))
                dfs(row+1, col)
                dfs(row-1, col)
                dfs(row, col+1)
                dfs(row, col-1)


        seen = set()
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and (i,j) not in seen:
                    dfs(i, j)
                    ans +=1
        return ans

