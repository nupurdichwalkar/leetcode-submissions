class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[2];
        if(n<=2)
            return n;
        stairs[0] = 1;
        stairs[1] = 2;
        int ans=0;
        for(int i = 3; i <= n; i++)
        {
            ans = stairs[0]+stairs[1];
            stairs[0] = stairs[1];
            stairs[1] = ans;
        }
        return ans;
    }
}
