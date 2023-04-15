// class TicTacToe {
//     private int[][] board;
//     private int n;

//     public TicTacToe(int n) {
//         this.n = n;
//         board = new int[n][n];
//     }
    
//     public int move(int row, int col, int player) {
//         board[row][col] = player;
//         if (checkRow(row, player) || checkCol (col, player) || (row == col && checkDiagonal(player)) || (col == n-row-1 && checkAntiDiagonal(player))){
//             return player;
//         }

//         return 0;
//     }

//     private boolean checkRow(int row, int player) {
//         for (int i = 0; i< n ; i++) {
//             if (board[row][i] != player) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean checkCol(int col, int player) {
//         for (int i = 0; i< n ; i++) {
//             if (board[i][col] != player) {
//                 return false;
//             }
//         }
//         return true;
//     }


//     private boolean checkDiagonal(int player) {
//         for (int i = 0; i< n ; i++) {
//             if (board[i][i] != player) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean checkAntiDiagonal(int player) {
//         for (int i = 0; i< n ; i++) {
//             if (board[i][n-i-1] != player) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

class TicTacToe {
    int n;
    int[] pRow;
    int[] pCol;
    int pD, pAD;

    TicTacToe(int n) {
        this.n = n;
        pRow = new int[n];
        pCol = new int[n];
    }

    public int move(int row, int col, int player) {
        //can track row,col,pd,pad each with ONLY one variable for both player 1 and player 2
        //(sum of n => player 1 wins) 
        //(sum of -n => player 2 wins)
        int incr = player==1 ? 1 : -1;
        
        pRow[row]+=incr;
        pCol[col]+=incr;
        if (row == col) {
            pD += incr;
        }
        if(row == n-col-1) {
            pAD += incr;
        }
        if (Math.abs(pRow[row]) == n || Math.abs(pCol[col]) == n || Math.abs(pD) ==n || Math.abs(pAD) == n) {
            return player;
        }        
        return 0;
    }
}










