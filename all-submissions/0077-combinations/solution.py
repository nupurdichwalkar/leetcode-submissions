class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res =[] 
        def backtrack(num, arr):
            if len(arr) == k:
                res.append(arr[:])
                return
            for i in range(num, n+1):
                arr.append(i)
                backtrack(i+1, arr)
                arr.remove(i)

        backtrack(1, [])
        return res

