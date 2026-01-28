class Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        x_str = 'X'
        o_str = 'O'
        x_count = 0
        o_count = 0
        for row in board:
            x_count += row.count(x_str)
            o_count += row.count(o_str)
        if o_count > x_count: return False
        if x_count-o_count > 1: return False
        # if x_count == o_count == 0 : return True
        # if x_count == 5 and o_count == 4: return True


        def winner(player):
            for i in range(3):
                if (player == board[i][0] == board[i][1] == board[i][2]):
                    return True
                if (player == board[0][i] == board[1][i] == board[2][i]):
                    return True
            if all(player == board[i][i] for i in range(3)): return True
            if all(player == board[i][2-i] for i in range(3)): return True
            return False
        x_win = winner(x_str) 
        o_win = winner(o_str)
        if x_win and o_win: return False
        if x_win and o_count != x_count -1: 
            return False
        if o_win and o_count != x_count: 
            return False
        return (x_count == o_count) or (x_count == o_count + 1)
        return True
