class MinStack {

    int top=-1;
    List<Integer> stack=new ArrayList<>();
    public MinStack() {
       stack=new ArrayList<>(); 
    }
    
    public void push(int val) {
        stack.add(val);
        ++top;
    }
    
    public void pop() {
       stack.remove(top);
       --top; 
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return stack.stream().min(Comparator.naturalOrder()).get();
    }
}
