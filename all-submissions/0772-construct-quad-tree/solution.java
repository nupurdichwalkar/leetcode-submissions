/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    public boolean checkifisLeaf(int size, int startRow, int startColumn, int[][] grid) {
        int endRowIndex = startRow + size;
        int endColumnIndex = startColumn + size;
        int val = grid[startRow][startColumn];
        for(int i = startRow; i<endRowIndex; i++){
            for(int j= startColumn; j<endColumnIndex; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public Node solve(int size, int startRow, int startColumn, int[][] grid) {
        if(checkifisLeaf(size, startRow, startColumn, grid)){
            return new Node(grid[startRow][startColumn] == 1, true);
        }
        Node root = new Node(false, false);
        root.topLeft = solve(size/2, startRow, startColumn, grid);
        root.bottomLeft = solve(size/2, startRow+size/2, startColumn, grid);
        root.bottomRight = solve(size/2, startRow+size/2, startColumn + size/2, grid);
        root.topRight = solve(size/2, startRow, startColumn + size/2, grid);
        return root;
    }

    public Node construct(int[][] grid) {
        Node root = new Node();
        if(checkifisLeaf(grid.length, 0,0, grid)){
            root.isLeaf = true;
            root.val = grid[0][0] == 1;
            return root;
        }
        return solve(grid.length, 0, 0 ,grid);
    }
}
