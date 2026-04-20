class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        nums.sort()


        def threeSum(nums: List[int], target:int) -> List[List[int]]:
            if nums is None or len(nums) < 3: return []
            answer = []
            for i in range(len(nums)-2):
                if (i>0 and nums[i] == nums[i-1]): 
                    continue
                j = i +1 
                k = len(nums)-1
                while(j < k):
                    sum = nums[i] + nums[j] + nums[k] 
                    if sum == target:
                        answer.append([nums[i],nums[j],nums[k]])
                        j+=1
                        k-=1
                        while(0 < j < len(nums) and nums[j] == nums[j-1]): j+=1
                        while(k<len(nums)-1 and k>=0 and nums[k] == nums[k+1]): k -=1
                    elif sum > target:
                        k-=1
                    else: 
                        j+=1
            return answer



        for i in range(len(nums)):
            if i != 0 and nums[i] == nums[i-1]:
                continue
            for each_ans in threeSum(nums[i+1:], target-nums[i]):
                res.append([nums[i]] + each_ans)
        return res	
