class MovingAverage {
    double sum;
    Queue<Integer> q= new LinkedList<>(); 
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
            if(q.size()==size)
            {
                sum -= q.poll();
            } 
        sum += val;
        q.offer(val);
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
