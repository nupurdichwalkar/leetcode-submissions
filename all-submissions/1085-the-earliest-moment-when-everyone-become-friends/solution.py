class Solution:
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:
        root = [i for i in range(n)]
        rank = [0]*n	
        def find(x):
            if x != root[x]:
                root[x] = find(root[x])
            return root[x]

        def union(x,y):
            rootX, rootY = find(x), find(y)
            if rootX == rootY:
                return 0
            if rank[rootX] > rank[rootY]:
                root[rootY] = rootX
            else:
                root[rootX] = rootY
            return 1

        count = n
        logs.sort(key = lambda x:x[0])
        for ts, x, y in logs:
            count -= union(x,y)
            if count == 1:
                return ts
        return -1  
