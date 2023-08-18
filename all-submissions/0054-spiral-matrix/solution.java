class Solution {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    

    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        int currentDirection = 0;
        int row = 0;
        int column = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        result.add(matrix[0][0]);
        // The number of times we change the direction.
        int changeDirection = 0;
        while (changeDirection < 2) {
            while (row + directions[currentDirection][0] >= 0 &&
                   row + directions[currentDirection][0] < rows &&
                   column + directions[currentDirection][1] >= 0 &&
                   column + directions[currentDirection][1] < columns &&
                   visited[row + directions[currentDirection][0]]
                   [column + directions[currentDirection][1]] != true) {
                // Reset this to 0 since we did not break and change the direction.
                changeDirection = 0;
                // Calculate the next place that we will move to.
                row = row + directions[currentDirection][0];
                column = column + directions[currentDirection][1];
                result.add(matrix[row][column]);
                visited[row][column] = true;
            }
            // Change our direction.
            currentDirection = (currentDirection + 1) % 4;
            // Increment change_direction because we changed our direction.
            changeDirection++;
        }
        return result;

    }
}
