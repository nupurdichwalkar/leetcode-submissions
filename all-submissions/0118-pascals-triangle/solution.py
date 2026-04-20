class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [[1]]
        if numRows == 1:
            return ans
        for i in range(2, numRows + 1):
            res = []
            curr = ans[-1]
            res.append(1)
            for j in range(len(curr)-1):
                res.append(curr[j] + curr[j+1])
            res.append(1)
            ans.append(res)
        return ans


