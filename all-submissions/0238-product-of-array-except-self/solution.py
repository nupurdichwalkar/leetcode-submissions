class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        left_prefix = [1]* n
        right_prefix = [1] * n
        left_prefix[0] = nums[0]
        right_prefix[n-1] = nums[n-1]
        for i in range(1, n):
            left_prefix[i] = left_prefix[i-1] * nums[i]
        for i in range(n-2, -1, -1):
            right_prefix[i] = right_prefix[i+1] * nums[i]
        res = [1]* n
        res[0] = right_prefix[1]
        res[n-1] = left_prefix[n-2]
        for i in range(1, n-1):
            res[i] = left_prefix[i-1] * right_prefix[i+1]
        return res


