class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp ={}

        def dfs(currAmount):
            if currAmount > amount:
                return -1
            if currAmount == amount:
                return 0
            if currAmount in dp:
                return dp[currAmount]
            dp[currAmount] = float("inf")
            for coin in coins:
                temp = dfs(currAmount + coin)
                if temp != -1:
                    dp[currAmount] = min(dp[currAmount], temp+1)
            return dp[currAmount]

        res = dfs(0)
        return res if res != float("inf") else -1
