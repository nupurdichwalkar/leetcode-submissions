class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length;i++)
        {
            for(int j = 0; j< board[i].length;j++)
            {
               if(board[i][j]==word.charAt(0) && dfs(i,j,board,word,0))
                   return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] board, String word, int count)
    {
        if(count == word.length())
            return true;
        if(i<0||j<0||i>=board.length||j>=board[i].length||board[i][j]!=word.charAt(count))
            return false;
        char temp = board[i][j];
        board[i][j]= ' ';
        boolean found = dfs(i+1,j,board,word,count+1) ||
                        dfs(i-1,j,board,word,count+1) ||
                        dfs(i,j+1,board,word,count+1) ||
                        dfs(i,j-1,board,word,count+1);
        
        board[i][j]=temp;
        
    return found;
    }
}
