class MovingAverage {
    int size;
    Queue<Integer> queue;
    int sum;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        if (queue.size() < size) {
            sum+=val;
            queue.add(val);
            return (double)sum/queue.size();
        }
        if (queue.size() == size) {
            sum = sum + val - queue.poll();
            queue.add(val);
            return (double)sum/queue.size();
        }
        return (double)sum/queue.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
