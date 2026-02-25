class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def check(val):
            curr_sum = 0
            curr_split = 0
            for num in nums:
                if curr_sum + num <= val:
                    curr_sum += num
                else:
                    curr_sum =num
                    curr_split+=1
            return curr_split+1

        left = max(nums)
        right = sum(nums)
        while(left <= right):
            mid = (left+right)//2
            if check(mid)<=k:
                right = mid-1
            else:
                left = mid+1
        return left
