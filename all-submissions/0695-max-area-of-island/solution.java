class Solution {

    class State{
        int row;
        int column;
        State(int row, int column) {
            this.row = row;
            this.column = column;
        }
    } 

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] directions= new int[][]{{0,1}, {0,-1}, {1, 0}, {-1,0}};
        Queue<State> queue = new LinkedList<>();
        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0; j<n;j++) {
                int currArea = 0;
                if(grid[i][j] == 1 && !seen[i][j]){
                    seen[i][j] = true;
                    currArea++;
                    queue.add(new State(i,j)); 
                    while (!queue.isEmpty()) {
                        State currState = queue.poll();
                        int currRow = currState.row;
                        int currCol = currState.column;
                        for(int[] direction : directions) {
                            int nextRow = currRow + direction[0];
                            int nextCol = currCol + direction[1];
                            if(isValid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]){
                                currArea++;
                                seen[nextRow][nextCol] = true;
                                queue.add(new State(nextRow, nextCol));
                            }
                        }
                    }
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    public boolean isValid(int row, int col, int[][] grid){
        return (row >=0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] == 1);
    }
}
