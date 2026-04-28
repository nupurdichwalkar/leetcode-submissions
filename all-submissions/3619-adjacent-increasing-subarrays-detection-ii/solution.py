class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        def check(k):
            if k == 1:
                return True
            count =1
            i=1

            while i+k < len(nums):
                if nums[i] > nums[i-1] and  nums[i+k]>nums[i-1+k]:
                    count+=1
                else:
                    count =1
                if count >= k:
                    return True
                i+=1
            return False
        
        left = 0 
        right = len(nums)//2
        k_ans=0
        while(left <=right):
            mid = (left+right)//2
            if check(mid):
                k_ans=mid
                left = mid+1
            else:
                right = mid-1
        return k_ans
