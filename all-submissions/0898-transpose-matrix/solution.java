class Solution {
    public int[][] transpose(int[][] A) {
        if(A.length==1 && A[0].length ==1)
            return A;
        int row = A.length;
        int col = A[0].length;
        int[][] res = new int[col][row];
        
        for(int i=0; i<A.length; i++)
        {
            for(int j = 0; j<A[0].length;j++)
            {
              res[j][i]=A[i][j];
            }
        }
        return res;
    }
}
