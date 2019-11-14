class Solution {
    public class Point{
        int x;
        int y;
        
        Point(int x, int y){
            this.x =x;
            this.y = y;
        }
    }
    
    private int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==1){
                    matrix[i][j] = -1;
                } else{
                    q.offer(new Point(i,j));
                }
            }
        }
        
        int length = 0;
        while(!q.isEmpty()){
            int size = q.size();
            length++;
            for(int i = 0; i< size; i++){
                Point currPoint = q.poll();
                for(int[] dir :dirs){
                    int new_x = currPoint.x + dir[0];
                    int new_y = currPoint.y + dir[1];
                
                    if(new_x>=0 && new_y >=0 && new_x < rows && new_y<cols ){
                            if(matrix[new_x][new_y]==-1){
                                matrix[new_x][new_y] = length;
                                q.offer(new Point(new_x,new_y));
                            }
                    }
                }
            }
        }
        return matrix;
    }
}
