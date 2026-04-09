class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9

        rows = [set() for _ in range(N)]
        cols = [set() for _ in range(N)]
        boxes = [set() for _ in range(N)]

        for r in range(N):
            for c in range(N):
                val = board[r][c]
                if val == ".":
                    continue

                if val in rows[r]:
                    return False
                if val in cols[c]:
                    return False
                box_idx = (r//3)*3 + c//3
                if val in boxes[box_idx]:
                    return False
                rows[r].add(val)
                cols[c].add(val)
                boxes[box_idx].add(val)
        return True
