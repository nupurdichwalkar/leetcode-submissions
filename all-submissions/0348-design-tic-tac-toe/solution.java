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
    int[] p1Row, p2Row;
    int[] p1Col, p2Col;
    int p1D, p2D, p1AD, p2AD;

    TicTacToe(int n) {
        this.n = n;
        p1Row = new int[n];
        p2Row = new int[n];
        p1Col = new int[n];
        p2Col = new int[n];
    }

    public int move(int row, int col, int player) {
        if (player == 1) {
            p1Row[row]++;
            p1Col[col]++;
            if (row == col) {
                p1D ++;
            }
            if(row == n-col-1) {
                p1AD ++;
            }
            if (p1Row[row] == n || p1Col[col] == n || p1D ==n || p1AD == n) {
                return player;
            }
        } else {
            p2Row[row]++;
            p2Col[col]++;
            if (row == col) {
                p2D ++;
            }
            if(row == n-col-1) {
                p2AD ++;
            }
            if (p2Row[row] == n || p2Col[col] == n|| p2D==n || p2AD==n) {
                return player;
            }
        }
        return 0;

    }
}










