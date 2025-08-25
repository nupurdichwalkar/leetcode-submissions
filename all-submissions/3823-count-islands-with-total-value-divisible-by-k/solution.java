class Solution {

    class State {
        int row;
        int col;
        State(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int countIslands(int[][] grid, int k) {
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1},{-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<State> queue = new LinkedList<>();
        int numIslands = 0;

        boolean[][] seen = new boolean[m][n];
        for(int i = 0; i<m; i++) {
            for(int j=0; j<n ; j++) {
                if(grid[i][j] != 0 && !seen[i][j]) {
                    seen[i][j] = true;
                    int currSum = grid[i][j];
                    queue.add(new State(i, j));
                    while(!queue.isEmpty()) {
                        State currState = queue.poll();
                        int row = currState.row;
                        int col = currState.col;
                        for(int[] direction: directions) { 
                            int nextRow = row + direction[0];
                            int nextCol = col + direction[1];
                            if(isValid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]){
                                seen[nextRow][nextCol] = true;
                                queue.add(new State(nextRow, nextCol));
                                currSum += grid[nextRow][nextCol];
                            }
                        }
                    }
                    if (currSum % k ==0) {
                        numIslands++;
                    }
                }
            }
        }
        return numIslands;
    }

    public boolean isValid(int row, int col, int[][] grid) {
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0);
    }
}
