class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        current_num = 0
        operation = "+"
        for i in range(len(s)):
            char = s[i]
            if char.isdigit():
                current_num = current_num*10 + int(char)
            if not char.isdigit() and not char.isspace() or i == len(s)-1:
                if operation == "-":
                    stack.append(-current_num)
                if operation == "+":
                    stack.append(current_num)
                if operation == "*":
                    stack.append(stack.pop() * current_num)
                if operation == "/":
                    stack.append(int(stack.pop()/ current_num))
                operation = char
                current_num = 0

        return sum(stack)
