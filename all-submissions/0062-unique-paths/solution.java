class Solution {

    

    public int uniquePathsRecur(int m, int n, int x, int y, int[][]dp) {
        if(x == m-1 && y == n-1) return 1;
        if(x >=m || y >=n) return 0;
        if(dp[x][y]!= 0) return dp[x][y]; 
        int right = uniquePathsRecur(m, n, x, y+1, dp);
        int down = uniquePathsRecur(m, n, x+1, y, dp);
        dp[x][y] = right + down;
        return dp[x][y];
    }


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePathsRecur(m, n, 0, 0, dp);
    }
}
