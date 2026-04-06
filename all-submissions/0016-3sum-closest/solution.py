class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        curr_diff = float("inf")
        ans = 0
        nums.sort()
        for i in range(len(nums)-2):
            j = i+1
            k= len(nums)-1
            while(j<k):
                curr_sum = nums[i] + nums[j] + nums[k]
                if abs(target-curr_sum) < curr_diff:
                    ans = curr_sum
                    curr_diff = abs(target-curr_sum)
                if curr_sum < target:
                    j+=1
                else:
                    k-=1
        return ans


