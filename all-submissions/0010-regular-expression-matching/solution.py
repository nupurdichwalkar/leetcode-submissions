# Reference :https://www.youtube.com/watch?v=HAA8mgxlov8

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = {}
        def dfs(s_i, p_i):
            if p_i == len(p):
                return s_i == len(s)
            if (s_i, p_i) in dp:
                return dp[(s_i,p_i)]
            match = s_i < len(s) and (s[s_i] == p[p_i] or p[p_i] == ".")
            if  p_i+1 < len(p) and p[p_i+1] == '*':
                dp[(s_i, p_i)] = dfs(s_i, p_i+2) or (match and dfs(s_i+1, p_i))
                return dp[(s_i, p_i)]
            if match:
                dp[(s_i, p_i)] = dfs(s_i+1, p_i+1)
                return dp[(s_i, p_i)]
            dp[(s_i, p_i)] =  False
            return False
        return dfs(0,0)
