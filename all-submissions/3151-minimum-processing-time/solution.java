

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks, Collections.reverseOrder());
        Collections.sort(processorTime);

        int minProcessingTime = 0;
        int i = 0;

        for(int j = 0; j< processorTime.size();j++) {
            int timeTofinishAlltasks = processorTime.get(j) + tasks.get(i);
            i += 4;            
            minProcessingTime = Math.max(timeTofinishAlltasks, minProcessingTime);
        }
        return minProcessingTime;
    }
}
