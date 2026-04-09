class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        n = len(nums)//2
        d = Counter(nums)
        for num in d.keys():
            if d[num] == n:
                return num
