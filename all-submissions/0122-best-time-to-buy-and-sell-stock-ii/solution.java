class Solution {
    public int maxProfit(int[] prices) {
        // if (prices.length == 1) return 0;
        // int total = 0;
        // int local_min = Integer.MAX_VALUE;
        // int local_max = local_min;
        // for (int i = 0; i< prices.length; i++) {
        //     if (prices[i] < local_max) {
        //         total += (local_max - local_min);
        //         local_min = prices[i];
        //         local_max = local_min;
        //     }
        //     else {
        //          local_max = prices[i];    
        //     }
        // }

        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
        
        // return total;

        
    }
}
