class MinStack {
    Stack<Integer> minStk;
    Stack<Integer> stk;
    public MinStack() {
        minStk = new Stack<>();
        stk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty()) {
            minStk.push(val);
        } else {
            minStk.push(Math.min(minStk.peek(), val));
        }
        
    }
    
    public void pop() {
        minStk.pop();
        stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}
