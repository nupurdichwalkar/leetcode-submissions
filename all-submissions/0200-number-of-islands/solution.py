class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # visited = set()
        # ROWS = len(grid)
        # COLS = len(grid[0])

        # def dfs(r, c):
        #     if r < 0 or r >=ROWS or c <0 or c >= COLS:
        #         return
        #     if grid[r][c] == "1" and (r,c) not in visited:
        #         visited.add((r,c))
        #         dfs(r+1,c)
        #         dfs(r-1,c)
        #         dfs(r, c+1)
        #         dfs(r, c-1)

        # ans = 0
        # for r in range(ROWS):
        #     for c in range(COLS):
        #         if grid[r][c] == "1" and (r,c) not in visited:
        #             ans+=1
        #             dfs(r, c)
        # return ans



        queue = deque()
        visited = set()
        ROWS = len(grid)
        COLS = len(grid[0])
        ans = 0
        directions = [(1,0), (-1,0), (0,-1), (0,1)]

        def isValid(r,c):
            return 0<=r<ROWS and 0<=c<COLS and grid[r][c] == "1"

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == "1" and (r,c) not in visited:
                    ans +=1
                    queue.append((r,c))
                    visited.add((r,c))
                    while(queue):
                        row, col = queue.popleft()
                        for dr,dc in directions:
                            nr = row + dr
                            nc = col + dc
                            if isValid(nr, nc) and (nr, nc) not in visited:
                                queue.append((nr, nc))
                                visited.add((nr, nc))
        return ans
