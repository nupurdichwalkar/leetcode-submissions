class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        # create graph
        def dfs(node):
            for neighbor in graph[node]:
                if neighbor not in seen:
                    seen.add(neighbor)
                    dfs(neighbor)
        graph = defaultdict(list)
        for i in range(len(isConnected)):
            for j in range(i+1, len(isConnected)):
                if isConnected[i][j] == 1:
                    graph[j].append(i)
                    graph[i].append(j)
        seen = set()
        ans = 0
        for i in range(len(isConnected)):
            if i not in seen:
                ans += 1
                seen.add(i)
                dfs(i)
        return ans
