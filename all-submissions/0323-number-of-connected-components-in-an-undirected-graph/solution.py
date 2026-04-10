class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = defaultdict(list)
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])

        def dfs(i):
            for edge in adj[i]:
                if edge not in visited:
                    visited.add(edge)
                    dfs(edge)
        count = 0
        visited = set()
        for i in range(n):
            if i not in visited:
                count +=1
                visited.add(i)
                dfs(i)

        return count
