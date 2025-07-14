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

    int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};



    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<State> queue = new LinkedList<>();
        boolean[][] seen = new boolean[rows][cols];

        for(int row = 0; row<rows; row++) {
            for(int col = 0; col < cols ; col++) {
                if (rooms[row][col] == 0) {
                    queue.add(new State(row, col,0));
                    seen[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row;
            int col = state.col;
            int steps = state.steps;

            for(int i =0 ;i< directions.length; i++) {
                int nextRow = row + directions[i][0];
                int nextCol = col + directions[i][1];
                if (isValid(nextRow, nextCol, rooms) && !seen[nextRow][nextCol]){
                    queue.add(new State(nextRow, nextCol, steps+1));
                    seen[nextRow][nextCol] = true;
                    rooms[nextRow][nextCol] = steps+1;
                }
            }
        }
        
    }

    public boolean isValid(int nextRow, int nextCol, int[][]rooms) {
        return (nextRow >= 0 && nextRow < rooms.length && nextCol >= 0 && nextCol<rooms[0].length
        && rooms[nextRow][nextCol] == Integer.MAX_VALUE);
    }
}
