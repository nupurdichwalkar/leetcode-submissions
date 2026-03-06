class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid: 
            return -1
        ROWS = len(grid)
        COLS = len(grid[0])
        queue= deque()
        fresh = 0
        min_mins = 0
        directions = [(0,1),(1,0), (-1,0),(0,-1)]
        for i in range(ROWS):
            for j in range(COLS): 
                if grid[i][j] == 2:
                    queue.append((i,j))
                elif grid[i][j] == 1:
                    fresh += 1
        
        # edge case: no fresh oranges
        if fresh == 0:
            return 0
        while queue and fresh > 0:
            min_mins+=1
            queue_len = len(queue)
            for  _ in range(queue_len):
                row, col = queue.popleft()
                for dr,dc in directions:
                    nr = row+dr
                    nc = col +dc
                    if 0<=nr<ROWS and 0<=nc<COLS and grid[nr][nc] == 1:
                        fresh -=1
                        grid[nr][nc] = 2
                        queue.append((nr, nc))
            
        
        return min_mins if fresh == 0 else -1

