class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals.sort(key = lambda x: x[0])
        minHeap = []
        heapq.heappush(minHeap, intervals[0][1])
        for s_time,e_time in intervals[1:]:
            if s_time >= minHeap[0]:
                heapq.heappop(minHeap)
            heapq.heappush(minHeap, e_time)
        return len(minHeap)
