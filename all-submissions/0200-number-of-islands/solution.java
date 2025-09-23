class Solution {

    class State {
        int row;
        int col;
        State(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int answer = 0;
        Queue<State> queue = new LinkedList<>();
        for(int r=0; r<m;r++) {
            for (int c=0; c<n; c++) {
                if(grid[r][c] == '1' && !seen[r][c]) {
                    answer++;
                    queue.add(new State(r,c));
                    seen[r][c] = true;
                    while(!queue.isEmpty()) {
                        State state = queue.poll();
                        int row = state.row;
                        int col = state.col;
                        for(int i=0 ;i<directions.length; i++) {
                            int nextRow = row+directions[i][0];
                            int nextCol = col+directions[i][1];
                            if(isValid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                                seen[nextRow][nextCol] = true;
                                queue.add(new State(nextRow, nextCol));
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public boolean isValid(int row, int col, char[][] grid) {
        return (row >=0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] == '1');
    }
}
