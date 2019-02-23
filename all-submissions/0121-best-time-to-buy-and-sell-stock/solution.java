class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int maxprofit = 0;
        int buy = prices[0];
        for(int i =0 ; i<prices.length; i++){
            if(prices[i]>buy)
            {
                if(maxprofit< prices[i]-buy){
                    maxprofit = prices[i]- buy;
                }
            }
            else{
                buy = prices[i];
            }
        }
        return maxprofit;
    }
}
