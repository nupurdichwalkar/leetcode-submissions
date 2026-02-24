class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        prefix_sum = [0]*len(nums)
        nums.sort()
        prefix_sum[0] = nums[0]
        for i in range(1, len(nums)):
            prefix_sum[i] = prefix_sum[i-1] + nums[i]
        res = []
        for query in queries:
            left = 0
            right = len(prefix_sum) -1
            while left < right:
                mid = (left + right) //2
                if prefix_sum[mid] > query:
                    right = mid
                else:
                    left = mid+1
            if prefix_sum[left] > query:
                res.append(left)
            else:
                res.append(left+1)
        return res

