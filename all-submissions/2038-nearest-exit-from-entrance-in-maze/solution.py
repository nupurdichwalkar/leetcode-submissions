class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        queue = collections.deque()
        visited = set()
        queue.append((entrance[0], entrance[1], 0))
        visited.add((entrance[0], entrance[1]))
        ROWS = len(maze)
        COLS = len(maze[0])
        directions = [[0,1],[1,0], [-1,0], [0,-1]]

        def isValid(r,c):
            return 0<=r<ROWS and 0<=c<COLS and maze[r][c] == "."

        def isExit(r,c):
            return r ==0 or r== ROWS-1 or c == 0 or c== COLS-1

        while queue:
            row, col, steps = queue.popleft()
            
            for dr, dc in directions:
                nr = dr + row
                nc = dc + col
                if isValid(nr,nc) and (nr, nc)  not in visited:
                    if isExit(nr, nc):
                        return steps+1
                    queue.append((nr,nc, steps+1))
                    visited.add((nr,nc))
        return -1
