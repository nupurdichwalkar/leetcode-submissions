class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def isValid(row, col):
            return row >= 0 and row < m and col >= 0 and col < n and grid[row][col] == "1"
 
        def dfs(row, col):
            for dx, dy in directions:
                nextRow = row + dx
                nextCol = col + dy
                if isValid(nextRow, nextCol) and \
                    (nextRow, nextCol) not in seen :
                    seen.add((nextRow, nextCol))
                    dfs(nextRow, nextCol)

        directions = [(1,0), (0,1), (-1, 0), (0, -1)]
        seen = set()
        ans = 0
        m =len(grid)
        n = len(grid[0])
        for row in range(m):
            for col in range(n):
                if grid[row][col] == "1" and (row,col) not in seen:
                    ans +=1
                    seen.add((row, col))
                    dfs(row, col)
        return ans
