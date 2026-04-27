class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}

        def dfs(index, curr_total):
            if index == len(nums):
                if curr_total == target:
                    return 1
                else:
                    return 0
            if (index, curr_total) in dp:
                return dp[(index, curr_total)]
            
            dp[(index, curr_total)] = dfs(index+1, curr_total + nums[index]) + \
                                        dfs(index+1, curr_total - nums[index]) 
            return dp[(index, curr_total)]

        return dfs(0, 0)

