class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];

        for(int i= questions.length-1; i>=0;i--) {
            int j = i+questions[i][1]+1;
            dp[i] = Math.max(questions[i][0] + dp[Math.min(j, questions.length)], dp[i + 1]);
        }

        return dp[0];
    }
}
