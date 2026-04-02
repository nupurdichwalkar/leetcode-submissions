class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        left = 0
        right = len(nums)
        while left < right:
            if nums[left] == val:
                temp = nums[left]
                nums[left] = nums[right-1]
                nums[right-1] = temp
                right -=1
            else:
                left +=1
        
        return right
