class TicTacToe {
    private int[][] board;
    private int n;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(row, player) || checkCol (col, player) || (row == col && checkDiagonal(player)) || (col == n-row-1 && checkAntiDiagonal(player))){
            return player;
        }

        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int i = 0; i< n ; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int i = 0; i< n ; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        return true;
    }


    private boolean checkDiagonal(int player) {
        for (int i = 0; i< n ; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int i = 0; i< n ; i++) {
            if (board[i][n-i-1] != player) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
