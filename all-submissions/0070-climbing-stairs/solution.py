class Solution:
    def climbStairs(self, n: int) -> int:
        
        dp = {}

        def dfs(currStep):
            if currStep > n:
                return 0
            if currStep == n:
                return 1
            if currStep in dp:
                return dp[currStep]
            dp[currStep] = dfs(currStep+1) + dfs(currStep+2)
            return dp[currStep]
        
        return dfs(0)

