class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        def isValid(row, col):
            return 0<=row<len(board) and 0<=col<len(board[0]) and board[row][col] == "X"
	
        def dfs(row, col):
            if (isValid(row, col) and (row, col) not in seen):			
                seen.add((row, col))
                dfs(row+1, col)
                dfs(row-1, col)
                dfs(row, col+1)
                dfs(row, col-1)


        seen = set()
        ans = 0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == "X" and (i,j) not in seen:
                    dfs(i, j)
                    ans +=1
        return ans

