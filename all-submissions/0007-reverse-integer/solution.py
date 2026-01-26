class Solution:
    def reverse(self, x: int) -> int:
        ans= 0 
        sign = 1
        if x < 0: 
            sign = -1
            x = x * sign
        while(x>0):
           temp = x%10
           x = x//10
           ans = ans * 10 + temp
           if (ans > 2**31-1):
            return 0
        return ans* sign
        
