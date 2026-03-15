class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        dict = {}
        for i in range(len(nums)):
            remain = target-nums[i]
            if remain in dict.keys():
	            return [dict[remain], i]
            dict[nums[i]] = i
        return [-1,-1]



