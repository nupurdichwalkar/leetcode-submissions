class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        def reverse():
            n = len(matrix)
            for i in range(n):
                row = matrix[i]
                row = row[::-1]
                matrix[i] = row
        
        def transpose():
            n = len(matrix)
            for i in range(n):
                for j in range(i+1, n):
                    temp = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = temp
        
        transpose()
        reverse()


        
