class Solution {
    public int connectSticks(int[] sticks) {
        
        int cost = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<sticks.length; i++) {
            heap.add(sticks[i]);
        }
        while(heap.size() > 1) {
            int first = heap.remove();
            int second = heap.remove();
            cost += first + second;
            heap.add(first+second);
        }
        return cost;
        
    }
}
