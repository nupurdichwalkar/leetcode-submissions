class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        ROWS = len(obstacleGrid)
        COLS = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1:
            return 0
        dp = [[0]*COLS for _ in range(ROWS)]
        dp[0][0] = 1
        for i in range(1,ROWS):
            if obstacleGrid[i][0] == 1:
                dp[i][0] = 0
            else:
                dp[i][0] = dp[i-1][0]

        for j in range(1,COLS):
            if obstacleGrid[0][j] == 1:
                dp[0][j] = 0
            else:
                dp[0][j] = dp[0][j-1]
        for i in range(1,ROWS):
            for j in range(1,COLS):

                if obstacleGrid[i][j] == 0:
                    left = dp[i][j-1] 
                    top = dp[i-1][j]
                    dp[i][j] = left + top
                else:
                    dp[i][j] = 0

        return dp[ROWS-1][COLS-1]

