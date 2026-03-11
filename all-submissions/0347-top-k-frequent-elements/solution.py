class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dic = {}
        for num in nums:
            dic[num] = dic.get(num, 0)+1
        heap = []
        for num, count in dic.items():
            heapq.heappush(heap, (count, num))
            if len(heap)>k:
                heapq.heappop(heap)

        return [num for count, num in heap]
