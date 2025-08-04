class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int answer = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prev_end = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if(prev_end > intervals[i][0]) { // overlap detected
                answer++;
                prev_end = Math.min(prev_end, intervals[i][1]);
            } else {
                prev_end = intervals[i][1];
            }
        }
        return answer;
    }
}
