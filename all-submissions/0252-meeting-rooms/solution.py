class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if not intervals:
            return True
        if len(intervals) == 0:
            return True
        intervals.sort(key = lambda x:x[0])
        end_time = intervals[0][1]
        for interval in intervals[1:]:
            if interval[0] < end_time:
                return False 
            end_time = interval[1]
        return True
