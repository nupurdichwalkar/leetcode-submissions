class Solution:
    def myAtoi(self, s: str) -> int:
        num = 0
        sign = 1
        i = 0
        while i < len(s):
            if s[i] == " ":
                i+=1
            else:
                break
        if i == len(s):
            return 0
        if s[i] == "-":
            sign = -1
            i+=1
        elif s[i] == "+":
            i+=1
        for j in range(i, len(s)):
            if not s[j].isdigit():
                break
            num = num * 10 + int(s[j])
            if num > 2**31-1:
                if sign == -1:
                    return -2**31
                else:
                    return 2**31-1

        return num*sign            
