class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]* len(nums)
        def dfs(currIndex):
            if currIndex == len(nums):
                return
            for i in range(currIndex): 
                if nums[i] < nums[currIndex]:
                    dp[currIndex] = max(dp[currIndex], dp[i]+1)
            dfs(currIndex+1)
        dfs(0)
        return max(dp)
