

import static java.lang.Math.max;

class Solution {
    class State{
        int row;
        int col;
        int steps;
        State(int row, int col,int  steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<State> cellsQueue = new LinkedList<>();
        State entranceState = new State(entrance[0], entrance[1], 0);
        cellsQueue.add(entranceState);
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int rowLength = maze.length;
        int colLength = maze[0].length;
        boolean[][] seen = new boolean[rowLength][colLength];
        seen[entrance[0]][entrance[1]] = true;

        while(!cellsQueue.isEmpty()){
            State currState = cellsQueue.poll();
            int row = currState.row;
            int col = currState.col;
            int steps = currState.steps;
            for(int[] direction: directions) {
                int nextRow = row +direction[0];
                int nextCol = col + direction[1];
                if(isValid(nextRow, nextCol, rowLength, colLength, maze) && !seen[nextRow][nextCol]){
                    if(isExit(nextRow, nextCol, rowLength, colLength)) {
                        return steps+1;
                    }
                    seen[nextRow][nextCol] = true;
                    cellsQueue.add(new State(nextRow, nextCol, steps+1));
                }
            }
        }
        return -1;
    }

    boolean isValid(int row, int col, int rowLength, int colLength, char[][]maze){
        return (row >=0 && row<rowLength && col >=0 && col < colLength && maze[row][col] != '+');
    }

    boolean isExit(int row, int col, int rowLength, int colLength){
        return (row == 0 || row == rowLength-1 || col ==0 || col == colLength-1);
    }
}
