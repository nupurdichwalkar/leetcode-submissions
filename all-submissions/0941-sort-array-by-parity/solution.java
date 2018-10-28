class Solution {
    public int[] sortArrayByParity(int[] A) {
        int temp;
        int insert = 0;
        for(int i=0; i<A.length;i++)
        {
            
            if(A[i]%2==0)
            {
                temp=A[i];
                A[i]=A[insert];
                A[insert]=temp;
                insert++;
            }
        }
        return A;
    }
}
