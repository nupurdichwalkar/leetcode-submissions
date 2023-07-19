class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        for(int num: nums) {
            heap.add(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        heap.add(val);
        while(heap.size() > k) {
            heap.remove();
        }
        int ans = heap.peek();
        // heap.add(ans);
        return ans;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
