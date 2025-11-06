class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int currMeetingRooms = 0;
        for(int[] interval: intervals){
            if(!queue.isEmpty() && queue.peek() <= interval[0]){
                queue.poll();
                queue.add(interval[1]);
            } else{
                queue.add(interval[1]);
                currMeetingRooms++;
            }
                     
        }
        return currMeetingRooms;
    }
}
