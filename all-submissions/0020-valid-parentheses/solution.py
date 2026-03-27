class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for char in s:
            if char == '(' or char == '{' or char == '[':
                stack.append(char)
            else:
                if not stack:
                    return False
                ch = stack.pop()
                if (ch == '(' and char == ')') or (ch == '{' and char == '}') or (ch == '[' and char == ']'):
                    continue
                else:
                    return False
        return True if not stack else False
