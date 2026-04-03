class MinStack {

    List<Integer> list=new ArrayList<>();
    List<Integer> listmin=new ArrayList<>();
    public MinStack() {
        list=new ArrayList<>();
        listmin=new ArrayList<>();
    }
    
    public void push(int val) {
        if(!list.isEmpty())
         listmin.add(Math.min(listmin.get(list.size()-1),val));
        else
         listmin.add(val);
        list.add(val);
    }
    
    public void pop() {
        list.remove(list.size()-1);
        listmin.remove(listmin.size()-1);
    }
    
    public int top() {
          return list.get(list.size()-1);
    }
    
    public int getMin() {
        return listmin.get(listmin.size()-1);
    }

}
