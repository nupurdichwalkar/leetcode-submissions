class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        left = 0
        right = 1
        if not nums: return 0
        currSum = nums[0]
        maxSum = nums[0]
        while(right < len(nums)):
            currSum += nums[right]
            if currSum < nums[right]:
                currSum = nums[right]
                left = right
            maxSum = max(maxSum, currSum)
            right+=1
        
        return maxSum
