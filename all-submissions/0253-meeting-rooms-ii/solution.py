class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals.sort(key = lambda x: x[0])
        minHeap = []
        heapq.heappush(minHeap, intervals[0][1])
        used_rooms = 1
        for i in range(1, len(intervals)):
            s_time = intervals[i][0]
            e_time = intervals[i][1]
            if s_time >= minHeap[0]:
                heapq.heappop(minHeap)
            heapq.heappush(minHeap, e_time)
        return len(minHeap)
