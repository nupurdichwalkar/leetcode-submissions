class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        root = [i for i in range(len(isConnected))]
        rank = [1] * len(isConnected)
        count = len(isConnected)
        def find(x):
            if x != root[x]:
                root[x] = find(root[x])
            return root[x]

        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rank[rootX] > rank[rootY]:
                root[rootY] = rootX
            elif rank[rootY] > rank[rootX]:
                root[rootX] = rootY
            else:
                root[rootY] = rootX
                rank[rootX] += 1
            

        def connected(x,y):
            return find(x) == find(y)

        for i in range(len(isConnected)):
            for j in range(i+1, len(isConnected)):
                if isConnected[i][j] == 1 and not connected(i, j):
                    count -=1
                    union(i, j)

        return count
