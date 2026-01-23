class Solution:
    def colorTheArray(self, n: int, queries: List[List[int]]) -> List[int]:
        # def getAdjacentPairs(colors):
        #     temp = 0
        #     for i in range(len(colors)-1):
        #         if colors[i] != 0 and colors[i] == colors[i+1]:
        #             temp += 1
        #     return temp
        colors = [0]* n
        res = [0] * len(queries)
        if n == 1:
            return res
        print(len(queries))
        i = 0
        ans = 0
        for index, color in queries:
            if (index > 0) and (colors[index] != 0) and (colors[index-1] == colors[index]):
                ans -= 1
            if (index < n-1) and (colors[index] != 0) and (colors[index+1] == colors[index]):
                ans -= 1
            colors[index] = color
            if (index > 0) and (colors[index] != 0) and (colors[index-1] == colors[index]):
                ans += 1
            if (index < n-1) and (colors[index] != 0) and (colors[index+1] == colors[index]):
                ans += 1
            res[i] = ans
            i +=1
        return res
        
