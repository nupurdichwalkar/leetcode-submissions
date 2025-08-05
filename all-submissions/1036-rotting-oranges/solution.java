class Solution {
    class State {
        int row;
        int col;
        int mins;
         State(int row, int col, int mins) {
            this.row = row;
            this.col = col;
            this.mins = mins;
        }
    }

    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<State> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];

        //get all rotten oranges in queue
        for(int i=0; i<m ;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new State(i,j,-1));
                    seen[i][j] = true;
                }
            }
        }
        int totalMins = 0;
        while(!queue.isEmpty()){
            State state = queue.poll();
            int row = state.row; int col = state.col; int mins= state.mins;
            for(int[] direction: directions) {
                int nextRow = row+direction[0];
                int nextCol = col+direction[1];
                if(isValid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]){
                    queue.add(new State(nextRow, nextCol, mins+1));
                    grid[nextRow][nextCol] = 2;
                    seen[nextRow][nextCol] = true;
                }
            }
            totalMins = mins+1;
        }

        for(int i=0; i<m ;i++) {
            for (int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return totalMins;
    }

    boolean isValid( int row, int col, int[][]grid) {
        return (row>=0 && row<grid.length 
        && col>=0 && col<grid[0].length 
        && grid[row][col] == 1);
    }
}
