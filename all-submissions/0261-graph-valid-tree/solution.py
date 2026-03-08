class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if(len(edges) != n-1): return False
        root = [i for i in range(n)]
        rank = [1] * n
        def find(x):
            if x != root[x]:
                root[x] = find(root[x])
            return root[x]
        
        def union(x,y):
            rootX,rootY = find(x), find(y)
            if rank[rootX] > rank[rootY]:
                root[rootY] = rootX
            elif rank[rootY] > rank[rootX]:
                root[rootX] = rootY
            else:
                root[rootY] = rootX
                rank[rootX] +=1

        def isConnected(x,y):
            return find(x) == find(y)

        for x,y in edges:
            union(x, y)
        
        for i in range(n):
            for j in range(i+1, n):
                if not isConnected(i,j):
                    return False

        return True
