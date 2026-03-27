class Solution:
    def canJump(self, nums: List[int]) -> bool:

        def canJumpFromPosition(index):
            if dp[index] != -1:
                return dp[index] == 1
            furthestJump = min(nums[index] + index, len(nums)-1)

            for nextIndex in range(index+1, furthestJump+1):
                if canJumpFromPosition(nextIndex):
                    dp[nextIndex] = 1
                    return True
            dp[index] = 0
            return False

        dp = [-1]*len(nums)
        dp[-1] = 1
        return canJumpFromPosition(0)

