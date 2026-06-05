class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(String c: tokens)
        {
            if(c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")){
                Integer b=stack.isEmpty()?null:stack.pop();
                Integer a=stack.isEmpty()?null:stack.pop();
                           
                if(a!=null && b!=null){
                    if(c.equals("+"))
                        stack.push(a+b);
                    else if(c.equals("-"))
                        stack.push(a-b);
                    else if(c.equals("*"))
                        stack.push(a*b);
                    else if(c.equals("/"))
                        stack.push(a/b);
                }
            }else{
                stack.push(Integer.valueOf(c));
            }
        }

        return stack.isEmpty()?-1:stack.pop();
    }
}
