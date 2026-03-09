class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        root = [i for i in range(n)]
        rank = [1] * n
        def find(x):
            if x != root[x]:
                root[x] = find(root[x])
            return root[x]
        
        def union(x,y):
            rootX,rootY = find(x), find(y)
            if rootX == rootY:
                return 0
            if rank[rootX] > rank[rootY]:
                root[rootY] = rootX
            elif rank[rootY] > rank[rootX]:
                root[rootX] = rootY
            else:
                root[rootY] = rootX
                rank[rootX] +=1
            return 1

        # def isConnected(x,y):
        #     return find(x) == find(y)

        count = n
        for i, j in edges:
            count -= union(i, j)

        return count
            
