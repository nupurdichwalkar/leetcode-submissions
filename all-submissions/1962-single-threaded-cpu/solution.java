class Solution {
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        int[][] sortedTasks = new int[len][3];

        for(int i=0; i< len; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        // sort by enqueque time
        Arrays.sort(sortedTasks, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> (a[1] != b[1] ? a[1] - b[1] : a[2]-b[2])) ;
        int[] taskProcessingOrder = new int[len];
        
        long currTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;
        
        // Stop when no tasks are left in array and heap.
        while(taskIndex < len || !queue.isEmpty()) {
            if(queue.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                currTime = sortedTasks[taskIndex][0];
            }
            // Push all the tasks whose enqueueTime <= currtTime into the heap.
            while(taskIndex < len && currTime >= sortedTasks[taskIndex][0]){
                queue.add(sortedTasks[taskIndex]);
                taskIndex++;
            }

            int processTime = queue.peek()[1];
            int currIndex = queue.peek()[2];
            currTime += processTime;
            queue.remove();
            taskProcessingOrder[ansIndex] = currIndex;
            ansIndex++;

        }

        return taskProcessingOrder;
       

    }
}
