class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        ans_set = set()
        for num in nums:
            if num in ans_set:
                ans_set.remove(num)
            else:
                ans_set.add(num)
        return list(ans_set)
