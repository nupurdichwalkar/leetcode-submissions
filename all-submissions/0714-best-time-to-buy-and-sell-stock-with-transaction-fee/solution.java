class Solution {

    int n;
    int[][] memo;

    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        memo = new int[n][2];
        for(int i=0; i<n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0, prices, fee);
    }

    public int dp(int i, int holding, int[] prices, int fee) {
        if(i== n) {
            return 0;
        }

        if (memo[i][holding] != -1){
            return memo[i][holding];
        }
        int answer = dp(i+1, holding, prices, fee);
        if(holding == 0) {
            int buy = -prices[i] + dp(i+1, 1, prices, fee);
            answer = Math.max(answer, buy);
        }
        else {
            int sell = prices[i] + dp(i+1, 0, prices, fee) - fee;
            answer = Math.max(answer, sell);
        }
        memo[i][holding] = answer;
        return answer;
    }

}
