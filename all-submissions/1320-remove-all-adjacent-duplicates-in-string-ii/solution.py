class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        for ch in s:
            if not stack or stack[-1][0] != ch:
                stack.append([ch,1])
            elif stack[-1][0] == ch:
                count = stack[-1][1] + 1
                stack.append([ch, count])
                if count == k:
                    while count > 0:
                        stack.pop()
                        count -=1
        res = ""
        for ch, count in stack:
            res += ch

        return res
        
