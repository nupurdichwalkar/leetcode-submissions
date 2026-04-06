class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        left = 0
        right = 1
        if not nums: return 0
        max_sum = nums[0]
        curr_sum = nums[0]
        while right < len(nums):
            curr_sum += nums[right]
            if curr_sum < nums[right]:
                curr_sum = nums[right]
                left = right
            max_sum = max(max_sum, curr_sum)
            right +=1
        return max_sum
