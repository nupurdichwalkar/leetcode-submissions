class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        counter = Counter(nums)
        res = []
        times = len(nums)//3
        for num, count in counter.items():
            if count > times:
                res.append(num)
        return res
