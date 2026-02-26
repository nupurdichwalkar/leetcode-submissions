class Solution:
    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        ROWS = len(grid)
        COLS = len(grid[0])
        visit = set()
        max_heap = []

        min_val = grid[0][0]
        visit.add((0, 0))
        heapq.heappush(max_heap, (-grid[0][0], 0, 0))
        directions = [(0,1), (1,0), (-1,0), (0,-1)]

        while max_heap:
            val, row, col = heapq.heappop(max_heap)
            min_val = min(min_val,-val)
            if (row == ROWS-1 and col == COLS - 1):
                return min_val
            for dr, dc in directions:
                nr = row+dr
                nc = col+dc
                if 0<=nr<ROWS and 0<=nc<COLS and (nr, nc) not in visit:
                    heapq.heappush(max_heap, (-grid[nr][nc], nr, nc))
                    visit.add((nr,nc))
        return min_val

