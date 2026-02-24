class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        min_heap = []
        directions = [(0,1), (1,0), (0,-1), (-1, 0)]
        ROWS = len(heights)
        COLS = len(heights[0])
        heapq.heappush(min_heap, (0, 0, 0))
        dist = [[float('inf')]*COLS for _ in range(ROWS)]
        dist[0][0] = 0
        while min_heap :
            effort, row, col = heapq.heappop(min_heap)
            if row == ROWS-1 and col == COLS-1:
                    return effort
            if effort > dist[row][col]:
                continue
            for dr, dc in directions:
                nr = dr + row
                nc = dc + col
                
                if 0<=nr<ROWS and 0<=nc<COLS:
                    curr_effort = max(effort, abs(heights[row][col] - heights[nr][nc]))
                    if (curr_effort < dist[nr][nc]):
                        dist[nr][nc] = curr_effort
                        heapq.heappush(min_heap, (curr_effort, nr, nc))
        
                    
