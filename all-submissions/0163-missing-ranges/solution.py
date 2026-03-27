class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[List[int]]:
        ans = []
        n = len(nums)
        if not nums:
            ans.append([lower, upper])
            return ans
        if lower == upper:
            return ans
        if nums[0] > lower:
            ans.append([lower, nums[0]-1])
        for i in range(1, n):
            if nums[i] != nums[i-1]+1:
                ans.append([nums[i-1]+1, nums[i]-1])
        if nums[n-1] < upper:
            ans.append([nums[n-1]+1, upper])
        return ans

