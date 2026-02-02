class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        if nums is None or len(nums) < 3: return []
        nums.sort()
        answer = []
        for i in range(len(nums)-2):
            if (i>0 and nums[i] == nums[i-1]): 
                continue
            j = i +1 
            k = len(nums)-1
            while(j < k):
                sum = nums[i] + nums[j] + nums[k] 
                if sum == 0:
                    answer.append([nums[i],nums[j],nums[k]])
                    j+=1
                    k-=1
                    while(0 < j < len(nums) and nums[j] == nums[j-1]): j+=1
                    while(k<len(nums)-1 and k>=0 and nums[k] == nums[k+1]): k -=1
                elif sum > 0:
                    k-=1
                else: 
                    j+=1
        return answer

