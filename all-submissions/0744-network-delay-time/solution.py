class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj_list = defaultdict(list)
        for u, v, w in times:
            adj_list[u].append((w,v))

        min_time = 0
        visited = set()
        heap = []
        heapq.heappush(heap, (0,k))
        while heap:
            dist, curr_node = heapq.heappop(heap)
            if curr_node in visited:
                continue
            visited.add(curr_node)
            min_time = max(min_time, dist)
            for d, c in adj_list[curr_node]:
                if c not in visited:
                    heapq.heappush(heap, (d+dist, c))
            
        return min_time if len(visited) == n else -1
