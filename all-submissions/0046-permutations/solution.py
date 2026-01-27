class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res =[]
        def backtrack(curr, used):
            if len(curr) == len(nums):
                res.append(curr[:])

            for num in nums:
                if num not in used:
                    used.add(num)
                    curr.append(num)
                    backtrack(curr, used)
                    used.remove(num)
                    curr.pop()
        backtrack([], set())
        return res
            
