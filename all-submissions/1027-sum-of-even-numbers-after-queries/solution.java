class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[A.length];
        int val =0;
        int index = 0;
        for(int i = 0; i< queries.length; i++)
        {
            val = queries[i][0];
            index = queries[i][1];
            A[index] += val;
            for(int j : A)
            {
                if(j % 2==0)
                    ans[i]+=j;
            }
        }
        return ans;
    }
}
