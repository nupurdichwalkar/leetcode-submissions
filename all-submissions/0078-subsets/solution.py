class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        def backtrack(curr_index, arr):
            res.append(arr[:])
            for i in range(curr_index, n):
                arr.append(nums[i])
                backtrack(i+1, arr)
                arr.remove(nums[i])
        backtrack(0, [])
        return res

