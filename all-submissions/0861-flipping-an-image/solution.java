class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
     
        
        for(int row = 0; row<A.length; row++)
        {
            int colend = A[row].length -1 ;
           for(int col = 0; col<colend; col++,colend--) 
            { 
                int temp = A[row][col];
                A[row][col] = A[row][colend];
                A[row][colend] = temp;
            }
        }
        for(int row = 0; row<A.length; row++)
        {
           for(int col = 0; col<A[0].length; col++) 
            { 
                A[row][col] ^=1;
            }
        }
        
           
        return A;
    }
}
