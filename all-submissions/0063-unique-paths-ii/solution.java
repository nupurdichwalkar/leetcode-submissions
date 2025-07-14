class Solution {
    int m;
    int n;
    int[][]memo;
    int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        this.memo = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(memo[i], -1);
        }
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        this.obstacleGrid = obstacleGrid;
        return getUniquePaths(m-1, n-1);
    }

    public int getUniquePaths(int row, int col) {
        if(row + col == 0) {
            return 1;
        }

        if(memo[row][col] != -1) {
            return memo[row][col];
        }
        int uniquePathsWithObstacles = 0;

        if(row > 0 && obstacleGrid[row-1][col] != 1 ) {
            uniquePathsWithObstacles += getUniquePaths(row-1, col);
        }
        if(col > 0 && obstacleGrid[row][col-1] != 1 ){
            uniquePathsWithObstacles += getUniquePaths(row, col-1);
        } 
        memo[row][col] = uniquePathsWithObstacles;
        return uniquePathsWithObstacles;

    }
}
