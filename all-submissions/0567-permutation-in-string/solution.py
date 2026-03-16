class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if not s1 or not s2:
            return False 
        if len(s2) < len(s1):
            return False
        s1 = "".join(sorted(s1))
        left =0
        right = len(s1)-1
        while(right<len(s2)):
            curr_substring = s2[left:right+1]
            curr_substring = "".join(sorted(curr_substring))
            if curr_substring == s1:
                return True
            else:
                left+=1
                right+=1

        return False
