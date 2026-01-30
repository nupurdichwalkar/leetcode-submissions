class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0: return 0
        dir = [(0,1),(1,0),(0,-1),(-1,0)]
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0]* n for _ in range(m)]
        ans = 0    
        
        def dfs(i, j):
            nonlocal m, n
            if dp[i][j] != 0: return dp[i][j]
            for r, c in dir:
                row = i+r
                col = j+c
                if row < 0 or row >= m or col < 0 or col >= n:
                    continue
                if matrix[row][col] > matrix[i][j]:
                    dp[i][j] = max(dp[i][j], dfs(row, col))
            dp[i][j]+= 1
            return dp[i][j]
       
        for i in range(m):
            for j in range(n):
                ans = max(ans, dfs(i, j))
        
        return ans


