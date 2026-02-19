class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = defaultdict(list)
        indegree = defaultdict(int)
        for dest, src in prerequisites:
            graph[src].append(dest)
            indegree[dest] +=1
        
        queue = collections.deque()
        for k in range(numCourses):
            if k not in indegree:
                queue.append(k)
        res = []
        while queue:
            vertex = queue.popleft()
            res.append(vertex)
            if vertex in graph:
                for neighbor in graph[vertex]:
                    indegree[neighbor] -=1
                    if indegree[neighbor] == 0:
                        queue.append(neighbor)

        return res if len(res) == numCourses else []
