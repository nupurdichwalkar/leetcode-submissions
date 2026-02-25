class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def create_board(state):
            board = []
            for row in state:
                board.append("".join(row))
            return board
        
        
        def backtrack(row, cols, diagonals, antidiagonals, state ):
            if row == n:
                ans.append(create_board(state))
                return
            for col in range(n):
                curr_diagonal = row-col
                curr_antidiagonal = row + col
                if (col in cols) or (curr_diagonal in diagonals) or (curr_antidiagonal in antidiagonals):
                    continue
                state[row][col] = "Q"
                cols.add(col)
                diagonals.add(curr_diagonal)
                antidiagonals.add(curr_antidiagonal)
                backtrack(row+1, cols, diagonals, antidiagonals, state)
                cols.remove(col)
                diagonals.remove(curr_diagonal)
                antidiagonals.remove(curr_antidiagonal)
                state[row][col] = "."
        empty_board = [["."] * n for _ in range(n)]
        ans = []
        backtrack(0, set(), set(), set(), empty_board)
        return ans 
