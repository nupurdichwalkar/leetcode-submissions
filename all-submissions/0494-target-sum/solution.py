class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp ={}

        def dfs(index, currSum):
            if index == len(nums)-1:
                if currSum == target:
                    return 1
                else:
                    return 0
            if (index, currSum) in dp:
                return dp[(index, currSum)]
            dp[(index, currSum)] = dfs(index+1, currSum - nums[index+1]) \
                                    + dfs(index+1, currSum + nums[index+1])
            return dp[(index, currSum)]
        
        # default_sum = nums[]
        return dfs(0,nums[0]) + dfs(0, -nums[0])
