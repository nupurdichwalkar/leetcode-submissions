class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        n = len(nums)
        steps = k%n
        if steps == 0:
            return
        def reverse(start, end):
            while start<end:
                nums[start], nums[end] = nums[end], nums[start]
                start, end = start+1, end-1

        reverse(0, n-1)
        reverse(0, steps-1)
        reverse(steps, n-1)
        return
