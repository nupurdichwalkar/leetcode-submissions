class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [-1] * len(s)

        def dfs(i):
            if i < 0:
                return True
            if dp[i] != -1:
                return dp[i] == 1
            
            for word in wordDict:
                if i >= len(word) - 1 and s[i-len(word)+1: i+1] == word:
                    if dfs(i-len(word)):
                        dp[i] = 1
                        return True
                    
            dp[i] = 0
            return False
        
        dfs(len(s)-1)
        return dp[len(s)-1] == 1
