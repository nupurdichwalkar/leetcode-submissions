class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[-1] * cols for _ in range(rows)] 
        def dfs(row, col):
            if row >=len(matrix) or col >= len(matrix[0]):
                return 0
            if dp[row][col] != -1:
                return dp[row][col] 
            
            right = dfs(row+1, col)
            bottom = dfs(row, col+1)
            diag = dfs(row+1, col+1)
            if matrix[row][col] == "1":
                dp[row][col]  = 1 + min(right, bottom, diag)
            else:
                dp[row][col]  = 0
            return dp[row][col]
        
        dfs(0,0)
        maxVal = -1
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                maxVal = max(maxVal, dp[i][j])
        return maxVal**2
