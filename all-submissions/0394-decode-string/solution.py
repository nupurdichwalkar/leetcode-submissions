class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        ans = []
        for ch in s:
            if ch.isdigit():
                stack.append(ch)
            if ch.isalpha():
                stack.append(ch)
            if ch == "[":
                stack.append(ch)
            if ch == "]":
                curr_s = ""
                count = 0
                while stack and stack[-1] != "[":
                    curr_s = stack.pop() + curr_s
                stack.pop()
                base = 1
                while stack and stack[-1].isdigit():
                    count = count + int(stack.pop())*base
                    base *=10
                # ans += [curr_s]* count 
                stack.append(curr_s*count)
        if stack:
            curr_str = ""
            while stack:
                curr_str = stack.pop() + curr_str
            ans += [curr_str]
        return "".join(ans)


