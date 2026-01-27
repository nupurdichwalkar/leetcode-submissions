class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def backtrack(curr, seen, num):
            if (len(curr) == k):
                res.append(curr.copy())
                return
            for i in range(num, n+1):
                if i not in seen:
                    seen.add(i)
                    curr.append(i)
                    backtrack(curr, seen, i+1)
                    seen.remove(i)
                    curr.pop()
        backtrack([], set(), 1)
        return res
