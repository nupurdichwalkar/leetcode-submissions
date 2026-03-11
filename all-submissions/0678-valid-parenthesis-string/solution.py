class Solution:
    def checkValidString(self, s: str) -> bool:
        left_stack = []
        asterisk_stack = []

        for i, ch in enumerate(s):
            if ch == "(":
                left_stack.append((ch, i))
            elif ch == "*":
                asterisk_stack.append((ch,i))
            else:
                if not left_stack and not asterisk_stack:
                    return False
                if left_stack:
                    left_stack.pop()
                elif asterisk_stack:
                    asterisk_stack.pop()
        
        while left_stack and asterisk_stack:
            left_index = left_stack[-1][1]
            asterisk_index = asterisk_stack[-1][1]
            if left_index > asterisk_index:
                return False
            left_stack.pop()
            asterisk_stack.pop()
        if not asterisk_stack and left_stack:
            return False
        # if not left_stack and 
        #     return False
        
        return True
            

            
