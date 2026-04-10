class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        # total_count = 0
        # for i in range(len(nums)):
        #     curr_prod = 1
        #     for j in range(i, len(nums)):
        #         curr_prod = curr_prod * nums[j]
        #         if curr_prod < k:
        #             total_count+=1
        #         else:
        #             break
        # return total_count

        left = 0
        right = 0
        total_count = 0
        prod = 1
        while right < len(nums):
            prod = prod * nums[right]
            while left<=right and prod >= k:
                prod = prod // nums[left]
                left+=1
            total_count+= right-left+1
            right +=1
        return total_count

