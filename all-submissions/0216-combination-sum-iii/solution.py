class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        def backtrack(curr_num, curr_sum, arr):
            if curr_sum == n and len(arr) == k:
                res.append(arr[:])
                return
            if curr_sum > n or len(arr) >= k:
                return
            for i in range(curr_num, 10):
                arr.append(i)
                backtrack(i+1, curr_sum+i, arr)
                arr.pop()
        backtrack(1,0,[])
        return res
