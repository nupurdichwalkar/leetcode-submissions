class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        def backtrack(curr_index, arr):
            if curr_index == n:
                res.append(arr[:])
            for num in nums:
                if num not in arr:
                    arr.append(num)
                    backtrack(curr_index + 1, arr)
                    arr.remove(num)
        backtrack(0, [])
        return res

