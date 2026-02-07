class Solution:
    def isHappy(self, n: int) -> bool:
        values = set()
        squares = [i**2 for i in range(10)]
        sum = 0
        while sum!=1:
            while(n != 0):
                unit = n%10
                sum += squares[unit]
                n = n //10
            if sum in values:
                break
            values.add(sum)
            n = sum
            sum = 0
        return True if sum == 1 else False

        
