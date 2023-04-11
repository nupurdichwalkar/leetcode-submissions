class Solution {

    private void dfs(char[][] grid, int row, int col, int rowLength, int colLength) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row-1, col, rowLength, colLength);
        dfs(grid, row+1, col, rowLength, colLength);
        dfs(grid, row, col-1, rowLength, colLength);
        dfs(grid, row, col+1, rowLength, colLength);

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int islandCount = 0;
        for (int i = 0; i< rowLength; i++) {
            for (int j = 0; j< colLength; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, rowLength, colLength);
                }
            }
        }
        return islandCount;

    }
}
