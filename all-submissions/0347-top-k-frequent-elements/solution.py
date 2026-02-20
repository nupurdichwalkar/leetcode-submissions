class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dic = defaultdict(int)
        for num in nums:
            dic[num] +=1
        min_heap = []
        for num, count in dic.items():
            heapq.heappush(min_heap,(count, num))
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        res = [num[1] for num in min_heap ] 
        return res
