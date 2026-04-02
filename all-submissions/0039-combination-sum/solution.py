class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        def backtrack(curr_sum, index, curr_res):
            if curr_sum == target:
                res.append(curr_res[::])
                return
            if curr_sum > target:
                return
            for i in range(index, len(candidates)):
                curr_res.append(candidates[i])
                backtrack(curr_sum + candidates[i], i, curr_res)
                curr_res.remove(candidates[i])
        
        backtrack(0, 0, [])
        
        return res
            
