class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> answer = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(answer.isEmpty() || answer.getLast()[1] < intervals[i][0]){
                answer.add(intervals[i]);
            }
            else{
                answer.getLast()[1] = Math.max(answer.getLast()[1], intervals[i][1]);
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }
}
