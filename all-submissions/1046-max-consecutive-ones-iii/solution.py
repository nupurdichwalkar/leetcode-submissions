class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        right = 0
        countZero = 0
        max_ones =0
        while right < len(nums):
            if nums[right] == 0:
                countZero +=1
                while countZero > k:
                    if nums[left] == 0:
                        countZero -= 1
                    left+=1
            max_ones = max(max_ones, right-left+1)
            right +=1
        return max_ones
