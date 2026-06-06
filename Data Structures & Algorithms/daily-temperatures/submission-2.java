class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty())
              r[i]=stack.peek()-i;
            stack.push(i);

        }
        
        return r;
    }
}
