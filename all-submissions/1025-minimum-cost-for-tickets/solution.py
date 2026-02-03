class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        dp ={}

        def dfs(currIndex):
            if currIndex == len(days):
                return 0
            if (currIndex) in dp:
                return dp[currIndex]
            dp[currIndex] = float("inf")
            for d, c in zip([1,7,30], costs):
                j = currIndex
                while j<len(days) and days[j] < days[currIndex]+d:
                    j+=1
                dp[currIndex] = min(dp[currIndex], c + dfs(j))
            return dp[currIndex]

        return dfs(0)
