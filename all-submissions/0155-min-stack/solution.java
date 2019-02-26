import java.util.*;
class MinStack {
     ArrayList<Integer> minstack;
     int point;
     int min;

    /** initialize your data structure here. */
    public MinStack() {
        minstack = new ArrayList<Integer>();
        point = -1;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        minstack.add(x);
        if(x < min)
        {
            min = x;
        }
        point++;
    }
    
    public void pop() {
        if(minstack.get(point)==min)
        {
            min = Integer.MAX_VALUE;
            for(int i=0; i<point; i++)
            {
                if(minstack.get(i) < min)
                    min = minstack.get(i);
            }
        }
        minstack.remove(point);
        point--;
    }
    
    public int top() {
        return minstack.get(point);
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
