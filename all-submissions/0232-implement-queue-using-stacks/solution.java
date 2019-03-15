class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    

    /** Initialize your data structure here. */
    public MyQueue() {
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty())
        {
            while(!s1.empty())
            {
                int t = s1.pop();
                s2.push(t);
            }
        }
            int s = s2.pop();
            return s;
    }
    
    /** Get the front element. */
    public int peek() {
       if(s2.empty())
        {
            while(!s1.empty())
            {
                int t = s1.pop();
                s2.push(t);
            }
        }
            int r = s2.peek();
            return r;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.empty()&&s2.empty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
