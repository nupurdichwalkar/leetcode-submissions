class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res= []
        def backtrack(openCount, closeCount, arr):
            if len(arr) == 2*n:
                res.append("".join(arr))
                return
            if openCount < n:
                arr.append("(")
                backtrack(openCount+1, closeCount, arr)
                arr.pop()
            if openCount > closeCount:
                arr.append(")")
                backtrack(openCount, closeCount+1, arr)
                arr.pop()
        backtrack(0,0,[])
        return res
            
