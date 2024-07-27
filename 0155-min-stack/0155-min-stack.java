import java.util.Stack;

class MinStack {
    Stack<Long> st = new Stack<>();
    long min;

    public MinStack() {
        // Constructor
    }
    
    public void push(int val) {
        long x = (long) val;
        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else if (x >= min) {
            st.push(x);
        } else {
            st.push(2 * x - min);
            min = x;
        }
    }
    
    public void pop() {
        if (st.isEmpty()) return;
        long top = st.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }
    
    public int top() {
        if (st.isEmpty()) return -1;
        long top = st.peek();
        if (top >= min) return (int) top;
        return (int) min;
    }
    
    public int getMin() {
        if (st.isEmpty()) return -1;
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
