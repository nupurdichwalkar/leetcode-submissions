class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indegree = defaultdict(int)
        adj_list = defaultdict(list)

        for dest, source in prerequisites :
            indegree[dest] +=1
            adj_list[source].append(dest)

        queue = deque()

        for i in range(numCourses):
            if i not in indegree:
                queue.append(i)

        ans = []

        while queue:
            course = queue.popleft()
            ans.append(course)
            for dep_course in adj_list[course]:
                indegree[dep_course] -=1
                if indegree[dep_course] == 0:
                    queue.append(dep_course)

        return ans if len(ans) == numCourses else []

        
