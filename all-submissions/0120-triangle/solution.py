class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp ={}

        def dfs(row, col):
            if (row, col) in dp:
                return dp[(row, col)]
            path = triangle[row][col]
            if (row < len(triangle)-1):
                path += min(dfs(row+1, col), dfs(row+1, col+1))
            dp[(row,col)] = path
            return path
        return dfs(0,0)
