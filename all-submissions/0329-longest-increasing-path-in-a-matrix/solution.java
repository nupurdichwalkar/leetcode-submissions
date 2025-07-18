class Solution {
    int m;
    int n;
    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for(int i=0; i< m;++i){
            for(int j=0; j<n;++j) {
                ans = Math.max(ans, dfs(i,j,matrix, cache));
            }
        }
        return ans;
    }

    public int dfs(int i, int j, int[][] matrix, int[][] cache){
        if(cache[i][j] != 0) return cache[i][j];
        for(int[] direction: directions) {
            int r= i+direction[0];
            int c = j+direction[1];
            if(r>=0 && c>=0 && r <m && c<n && matrix[r][c] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(r, c, matrix, cache));
            }
        }
        return ++cache[i][j];
    } 

    public boolean isValid(int row, int col, int[][] matrix){
        return (row>=0 && col>=0 && row <m && col<n);
    }
}
