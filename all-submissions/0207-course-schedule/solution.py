class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        adj = defaultdict(list)

        for prereq in prerequisites:
            adj[prereq[1]].append(prereq[0])
            indegree[prereq[0]] +=1

        queue = deque()
        visited = 0
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        
        while(queue):
            course = queue.popleft()
            visited +=1
            for c in adj[course]:
                indegree[c] -=1
                if indegree[c] == 0:
                    queue.append(c)

        return visited == numCourses


