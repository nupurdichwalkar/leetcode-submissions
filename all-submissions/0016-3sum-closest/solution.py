class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        ans = nums[0] + nums[1] + nums[2]
        diff = abs(target-ans)
        
        for i in range(n-2):
            j = i+1
            k = n-1
            while (j < k):
                curr_sum = nums[i] + nums[j] + nums[k]
                if curr_sum == target: return curr_sum
                curr_diff =  abs(target-curr_sum)
                if (curr_diff < diff): 
                    ans = curr_sum
                    diff = curr_diff
                if (curr_sum < target): 
                    j+=1
                else: 
                    k-=1
        return ans

