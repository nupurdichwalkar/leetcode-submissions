class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        indegree = [0]*n
        for fr, to in edges:
            indegree[to] +=1
        ans = []
        for i, node_count in enumerate(indegree):
            if node_count == 0:
                ans.append(i)

        return ans
