class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        if(stones.length == 2) return Math.abs(stones[0]-stones[1]);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0;i<stones.length;i++){
            queue.add(stones[i]);
        }

        while(queue.size() > 1) {
            int highest = queue.poll();
            int secondHighest = queue.poll();
            if(secondHighest == highest) {
                continue;
            } else {
                int diff = highest - secondHighest;
                queue.add(diff);
            }
        }
        if(queue.size() == 0) {
            return 0;
        } 
        return queue.poll();

        
    }
}
