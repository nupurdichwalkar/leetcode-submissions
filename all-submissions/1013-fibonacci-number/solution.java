class Solution {
    public int fib(int N) {
        if(N==0)
            return 0;
        int[] F = new int[N+1];
        F[0]=0;
        F[1]=1;
        for(int i =2; i<N+1; i++)
        {
            F[i] = F[i-1]+F[i-2];
        }
        return F[N];
    }
}
