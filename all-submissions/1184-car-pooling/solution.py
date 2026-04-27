class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        usedSeats = 0
        trips.sort(key = lambda x: x[1])
        min_heap = []   #earliest drop off,  seats dropped off
        for numP, pickup, dropoff in trips:
            while min_heap and min_heap[0][0] <= pickup:
                curr_earliest_dropoff, dropped_off_p = min_heap[0]
                heapq.heappop(min_heap)
                usedSeats = usedSeats - dropped_off_p
            if usedSeats + numP > capacity:
                return False
            usedSeats += numP
            heapq.heappush(min_heap,(dropoff, numP))
        return True
