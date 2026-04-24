class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        def dfs(n, ans):
            if n == len(graph)-1:
                res.append(ans[:])
            for i in graph[n]:
                ans.append(i)
                dfs(i, ans)
                ans.pop()

        dfs(0, [0])
        return res
