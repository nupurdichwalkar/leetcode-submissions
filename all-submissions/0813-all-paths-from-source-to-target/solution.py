class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        n = len(graph)
        def dfs(curr, path):
            if curr == n-1:
                res.append(path[:])
                return
            for i in graph[curr]:
                path.append(i)
                dfs(i, path)
                path.pop()
        dfs(0, [0])
        return res	
