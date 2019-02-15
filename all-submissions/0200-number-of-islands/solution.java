class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        for(int i =0; i< grid.length; i++)
        {
            for(int j =0; j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    islands++;
                    changetowater(grid,i,j);
                }
            }
        }
        return islands;
    }
    public void changetowater(char[][] grid, int i, int j)
    {
        if(i<0||j<0|| i>=grid.length|| j>=grid[0].length||grid[i][j]=='0')
            return;
        
        grid[i][j] = '0';
        
        changetowater(grid,i,j-1);
        changetowater(grid,i,j+1);
        changetowater(grid,i-1,j);
        changetowater(grid,i+1,j);
    }
}
