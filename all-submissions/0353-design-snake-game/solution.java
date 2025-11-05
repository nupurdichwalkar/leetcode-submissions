class SnakeGame {

    int height;

    int width;

    int[][] food;
    int currFoodIndex;
    int snakeSize;
    Deque<Pair<Integer, Integer>> occupied;

    Set<Pair<Integer, Integer>> occupiedSet;
    int[] currHead;
    Map<String, int[]> directionMap;

    public SnakeGame(int width, int height, int[][] food){
        this.height = height;
        this.width = width;
        this.currFoodIndex = 0;
        this.snakeSize = 1;
        this.food = food;
        this.directionMap = Map.of("U", new int[]{-1,0}, "D",  new int[]{1,0}, "L", new int[]{0,-1}, "R", new int[]{0,1});
        this.currHead = new int[]{0,0};
        this.occupied = new LinkedList<>();
        this.occupied.add(new Pair<>(0,0));
        this.occupiedSet = new HashSet<>();
        this.occupiedSet.add(new Pair<>(0,0));

    }


    //grid, int[][] food
    //int currFoodIndex;
    //moves(String direction)

    //
    //Map<String, int[] dir> directionMap;
    //int[][] occupied
    //int[] currHead;

    boolean isValid(int row, int col){
        return (row >=0 && row < height && col >= 0 && col < width);

    }

    boolean headOccupiesBody(int nextRow, int nextCol){
        Pair<Integer, Integer> tail = occupied.getLast();
        int tailRow = tail.getKey();
        int tailCol = tail.getValue();
        if(nextRow == tailRow && nextCol == tailCol) {
            return false;
        }
        Pair<Integer, Integer> p = new Pair(nextRow, nextCol);
        if(occupiedSet.contains(p)){
            return true;
        }
        return false;
    }
    
    public int move(String direction) {
        int[] dir = directionMap.get(direction);
        int nextRow = currHead[0] + dir[0];
        int nextCol = currHead[1] + dir[1];
        if(!isValid(nextRow, nextCol)) {
            return -1;
        }
        if(headOccupiesBody(nextRow, nextCol)){
            return -1;
        }
        if(currFoodIndex < food.length) {
            int foodRow = food[currFoodIndex][0];
            int foodCol = food[currFoodIndex][1];
            if (foodRow == nextRow && foodCol == nextCol) {
                // found food
                snakeSize++;
                currFoodIndex++;
            }
            else {
                Pair<Integer, Integer> p = occupied.removeLast();
                occupiedSet.remove(p);
            }
        } else {
            Pair<Integer, Integer> p = occupied.removeLast();
            occupiedSet.remove(p);
        }
        occupied.addFirst(new Pair<>(nextRow, nextCol));
        occupiedSet.add(new Pair<>(nextRow, nextCol));
        this.currHead = new int[]{nextRow, nextCol};
        return snakeSize-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
