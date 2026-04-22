class Solution:
    def canJump(self, nums: List[int]) -> bool:
        end = len(nums)
        i = 0

        for num in nums:
            if i < 0:
                return False
            
            elif num > i:
                i = num
            
            i-=1
        
        return True
        
