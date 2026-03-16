class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        buyPrice = float("inf")
        for i in range(len(prices)):
            if prices[i] <  buyPrice:
                buyPrice = prices[i]
            else:
                max_profit = max(max_profit, prices[i]-buyPrice)
        return max_profit
