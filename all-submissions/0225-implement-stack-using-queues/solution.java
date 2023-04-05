class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        
    }
    
    public void push(int x) {
        q1.add(x);
        
    }
    
    public int pop() {
        int size = q1.size();
        while (size > 1) {
            int x = q1.remove();
            q2.add(x);
            size --;
        } 

        int ans = q1.remove();
        while (!q2.isEmpty()) {
            int x = q2.remove();
            q1.add(x);
        } 
        return ans;
    }
    
    public int top() {
        int size = q1.size();
        while (size > 1) {
            int x = q1.remove();
            q2.add(x);
            size --;
        } 
        int ans = q1.peek();
        int x = q1.remove();
        q2.add(x);
        while (!q2.isEmpty()) {
            int y = q2.remove();
            q1.add(y);
        } 
        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
