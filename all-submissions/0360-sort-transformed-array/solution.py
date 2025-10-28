class Solution:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        heap = []
        res = []
        for i in nums:
            i = (a* math.pow(i,2)) + (b* i) + c
            heapq.heappush(heap ,int(i))
        while len(heap)>0:
            res.append(heapq.heappop(heap))
        return res
