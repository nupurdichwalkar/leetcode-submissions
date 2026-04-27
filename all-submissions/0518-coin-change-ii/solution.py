class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = {}

        def dfs(i, curr_amount):
            if curr_amount == amount:
                return 1
            if curr_amount > amount:
                return 0
            if i == len(coins):
                return 0
            if (i,curr_amount) in dp:
                return dp[(i, curr_amount)]
            
            dp[(i,curr_amount)] = dfs(i, curr_amount + coins[i]) + dfs(i+1, curr_amount) 
            return dp[(i,curr_amount)]

        return dfs(0,0)
