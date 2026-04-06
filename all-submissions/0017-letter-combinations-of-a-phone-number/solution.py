class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        map = {"2": "abc", 
                "3":"def", 
                "4": "ghi",
                "5":"jkl",
                "6": "mno", 
                "7": "pqrs",
                "8":"tuv",
                "9":"wxyz"}

        res = []
        def backtrack(curr_str, curr_index):
            if len(curr_str) == len(digits):
                res.append("".join(curr_str))
                return
            num = digits[curr_index]
            for c in map[num]:
                curr_str.append(c)
                backtrack(curr_str, curr_index+1)
                curr_str.pop()
        backtrack([], 0)
        return res

