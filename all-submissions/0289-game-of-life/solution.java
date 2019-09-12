class Solution {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        
        for(int i = 0; i <board.length;i++)
        {
            for(int j=0; j<board[0].length;j++)
            {
                int curr;
                
                curr = neighbours(board,i-1,j-1)+
                    neighbours(board,i-1,j)+
                    neighbours(board,i,j-1)+
                    neighbours(board,i+1,j+1)+
                    neighbours(board,i+1,j)+
                    neighbours(board,i,j+1)+
                    neighbours(board,i-1,j+1)+
                    neighbours(board,i+1,j-1);
                
                if(board[i][j]==1)
                {
                    if(curr<2)
                    {
                        res[i][j]=0;
                    }
                    else if (curr==2||curr==3)
                    {
                        res[i][j]=1;
                    }
                    else if (curr>3)
                    {
                        res[i][j]=0;
                    }
                }
                if(board[i][j]==0)
                {
                    if(curr==3)
                        res[i][j]=1;
                }
            }
        }
        
        for(int i = 0; i <board.length;i++)
        {
            for(int j=0; j<board[0].length;j++)
            {
                board[i][j]=res[i][j];
            }
        }
    }
    
    public int neighbours(int[][] board, int i, int j)
    {
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return board[i][j];
		return 0;
    }
}
