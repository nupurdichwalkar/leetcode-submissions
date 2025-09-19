class Solution {
    int n;
    int[][] memo;

    public int maxProfit(int[] prices) {
        n = prices.length;
        memo = new int[n][3];
        for(int i=0; i<n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(0, 0, prices);
    }

    public int dp(int index, int holding, int[] prices) {
        if (index == n) {
            return 0;
        }

        if(memo[index][holding] != -1) {
            return memo[index][holding];
        }

        int answer = dp(index+1, holding, prices);
        if (holding == 0) {
            int buy = -prices[index] + dp(index+1, 1, prices);
            answer = Math.max(answer, buy);
        } else if (holding == 1) {
            int sell = prices[index] + dp(index+1, 2, prices);
            answer = Math.max(answer, sell);
        } else if (holding ==2) {
            answer = dp(index+1, 0, prices);
        }

        memo[index][holding] = answer;
        return answer;
    }
}
