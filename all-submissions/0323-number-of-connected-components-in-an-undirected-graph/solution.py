class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        def dfs(edge):
            for neighbor in graph[edge]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    dfs(neighbor)

        # create graph
        graph = defaultdict(list)
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
        
        visited = set()
        count = 0
        for edge in range(n) :
            if edge not in visited:
                visited.add(edge)
                count +=1
                dfs(edge)
        return count
