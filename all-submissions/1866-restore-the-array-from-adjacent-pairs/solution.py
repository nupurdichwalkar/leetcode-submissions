class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        def dfs(val):
            nonlocal index
            values = graph[val]
            for value in values:
                if value not in seen:
                    seen.add(value)
                    res[index] = value
                    index +=1
                    dfs(value)
        #create graph
        graph = defaultdict(list)
        start = None
        for x, y in adjacentPairs:
            graph[x].append(y)
            graph[y].append(x)
        for key, values in graph.items():
            if len(values) == 1:
                start = key
                break
        res = [0] * len(graph)
        res[0] = start
        index = 1
        seen = set()
        seen.add(start)
        values = graph[start]
        for value in values:
            if value not in seen:
                seen.add(value)
                res[index] = value
                index +=1
                dfs(value)
        return res    
        
        
