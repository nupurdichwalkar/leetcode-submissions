class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        res =[0]*len(nums)
        for i in range(len(nums)): #0
            j = nums[i] #3
            if j > 0:
                num_index = ( i + j ) % len(nums)
                res[i] = nums[num_index]
            elif j < 0:
                j = abs(j)
                num_index = (i-j) % len(nums)
                res[i] = nums[num_index]
            elif j == 0:
                res[i] = nums[i]
        return res
