class MinStack {

    int top=-1;
    List<Integer> stack=new ArrayList<>();
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public MinStack() {
       stack=new ArrayList<>(); 
    }
    
    public void push(int val) {
        stack.add(val);
        ++top;
        pq.add(val);
    }
    
    public void pop() {
    	pq.remove(stack.get(top));
    	stack.remove(top);     
    	--top; 
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return pq.peek();
    }
}
