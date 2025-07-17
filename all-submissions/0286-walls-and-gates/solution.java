class Solution {
    class State {
        int row;
        int col;
        int steps;
        State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<State> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] seen = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == 0){
                    queue.add(new State(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int row = state.row;
            int col = state.col;
            int steps = state.steps;
            for(int[] direction: directions){
                int nextRow = row+direction[0];
                int nextCol = col+direction[1];
                if(isValid(nextRow, nextCol, rooms) && !seen[nextRow][nextCol]){
                    queue.add(new State(nextRow, nextCol, steps+1));
                    seen[nextRow][nextCol] = true;
                    rooms[nextRow][nextCol] = steps+1;
                }
            }
        }
        
    }

    public boolean isValid(int row, int col, int[][] rooms) {
        return (row>=0 && row<rooms.length 
        && col>=0 && col<rooms[0].length 
        && rooms[row][col] == Integer.MAX_VALUE);
    }
}
