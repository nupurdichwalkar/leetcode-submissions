class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = [-1]*len(nums)
        dp[-1] = 1
        def canJumpFromIndex(index):
            if dp[index] != -1:
                return dp[index] == 1
            if index == len(nums):
                return True
            if index > len(nums):
                return False
            furthestJump = min(nums[index]+1, len(nums))
            for i in range(1, furthestJump):
                if canJumpFromIndex(index+i):
                    dp[i] = 1
                    return True
            dp[index] = 0
            return False
        return canJumpFromIndex(0)
