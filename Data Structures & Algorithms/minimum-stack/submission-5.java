class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
       stack=new ArrayDeque<>(); 
       minStack=new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val) {
        	minStack.push(val);
        }
    }
    
    public void pop() {
    	if(!minStack.isEmpty() && minStack.peek().equals(stack.peek())) {
        	minStack.pop();
        }
    	stack.pop();     
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
