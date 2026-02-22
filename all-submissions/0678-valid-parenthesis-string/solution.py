class Solution:
    def checkValidString(self, s: str) -> bool:
        dp = [[-1]*len(s) for _ in range(len(s))]
        def isValid(currIndex, currCount):
            if currIndex == len(s):
                return currCount == 0
            if dp[currIndex][currCount] != -1:
                return dp[currIndex][currCount]==1
            is_valid = False
            if s[currIndex] == '*':
                is_valid = is_valid or isValid(currIndex+1, currCount+1)
                if currCount>0:
                    is_valid = is_valid or isValid(currIndex+1, currCount-1)
                is_valid = is_valid or isValid(currIndex+1, currCount)
            elif s[currIndex] == '(':
                is_valid = isValid(currIndex+1, currCount+1)
            elif currCount >0:
                is_valid = isValid(currIndex+1, currCount -1)
            dp[currIndex][currCount] = 1 if is_valid else 0
            return is_valid

        return isValid(0,0)

            
