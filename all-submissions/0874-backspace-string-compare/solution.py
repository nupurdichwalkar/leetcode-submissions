class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        stack_s = []
        stack_t = []
        for ch in s:
            if stack_s:
                if ch == "#":
                    stack_s.pop()
                else:
                    stack_s.append(ch)
            else:
                if ch != "#":
                    stack_s.append(ch)
        for ch in t:
            if stack_t:
                if ch == "#":
                    stack_t.pop()
                else:
                    stack_t.append(ch)
            else:
                if ch != "#":
                    stack_t.append(ch)
        return stack_s == stack_t
