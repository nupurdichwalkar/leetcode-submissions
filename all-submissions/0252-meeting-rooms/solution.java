class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length==0)
            return true;
//         int starts[] = new int[intervals.length];
//         int ends[] = new int[intervals.length];
//         for(int i = 0; i < intervals.length; i++){
//             starts[i] = intervals[i][0];
//             ends[i] = intervals[i][1];
//         }
        
//         Arrays.sort(starts);
//         Arrays.sort(ends);
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        for(int i = 0; i<intervals.length-1;i++)
        {
          if(intervals[i][1]>intervals[i+1][0])
              return false;
            else
                continue;
        }
        return true;
    }
}
