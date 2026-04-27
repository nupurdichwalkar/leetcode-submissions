class Solution:
    def countSubstrings(self, s: str) -> int:
        def expand(i,j):
            count = 0
            left = i
            right = j
            while left >=0 and right <len(s) and s[left] == s[right]:
                left -=1
                right +=1
                count +=1
            return count
        
        
        
        # ans = [0,0]
        count = 0
        # even_count = 0
        
        for i in range(len(s)):
            count += expand(i,i)
            # if odd_length > ans[1] - ans[0] + 1:
            #     dist = odd_length // 2
            #     ans = [i-dist, i+dist]

            count += expand(i, i+1)
            # if even_length > ans[1] - ans[0] + 1:
            #     dist = (even_length // 2) - 1
            #     ans = [i-dist, (i+1)+ dist]
            
            # i, j = ans
        return count
