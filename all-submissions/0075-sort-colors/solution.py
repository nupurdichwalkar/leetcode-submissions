class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeros=ones=twos=0
        for i in range(len(nums)):
            if nums[i] == 0:
                zeros +=1 
            if nums[i] == 1:
                ones +=1
            if nums[i] == 2:
                twos +=1


        index = 0
        while zeros > 0:
            nums[index] = 0
            index +=1
            zeros -=1
        while ones > 0:
            nums[index] = 1
            index+=1
            ones-=1
        while twos > 0:
            nums[index] = 2
            index +=1
            twos -=1

        
        
