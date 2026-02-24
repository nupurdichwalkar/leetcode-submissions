class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r = len(matrix)
        c = len(matrix[0])
        total_nums = r*c
        left = 0
        right = total_nums-1
        while(left <= right):
            mid = (left+right) // 2
            row = mid //c
            col = mid%c
            if matrix[row][col] == target:
                return True
            elif matrix[row][col] > target:
                right = mid-1
            else:
                left = mid+1
        return False

