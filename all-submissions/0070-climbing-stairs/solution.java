class Solution {

    public int climbStairsRecur(int n, int i, int[]dp) {
        if(i == n) return 1;
        if(i== n-1) return 1;
        if(dp[i] != 0) return dp[i];
        dp[i] =  climbStairsRecur(n, i+1, dp)  + climbStairsRecur(n, i+2, dp);
        return dp[i];

    }

    public int climbStairs(int n) {
        int[] dp = new int[n];
        return climbStairsRecur(n, 0, dp);

    }
}
