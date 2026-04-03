class MinStack {

    List<Integer> list=new ArrayList<>();
    public MinStack() {
        list=new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return list.stream().min(Comparator.naturalOrder()).get();
    }

}
