class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        def backtrack(curr, index):
            if index == len(graph)-1:
                res.append(curr.copy())
            for num in graph[index]:
                curr.append(num)
                backtrack(curr, num)
                curr.pop()
        backtrack([0], 0)
        return res
