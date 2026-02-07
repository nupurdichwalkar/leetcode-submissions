class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        def backtrack(currSum, currIndex, ans):
            if currSum == target:
                res.append(ans.copy())
                return 
            if currSum > target:
                return
            for i in range(currIndex, len(candidates)):
                ans.append(candidates[i])
                backtrack(currSum + candidates[i], i, ans)
                ans.pop()
        backtrack(0,0, [])
        return res

