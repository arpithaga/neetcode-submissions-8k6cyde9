class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(String c: tokens)
        {
            switch(c){
                case "+": stack.push(stack.pop()+stack.pop()); break;
                case "-": 
                   int b = stack.pop();
                   int a = stack.pop();
                   stack.push(a-b);
                   break;
                case "*": stack.push(stack.pop()*stack.pop()); break;
                case "/": 
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                default:
                    stack.push(Integer.valueOf(c));
                    break;
            }
        }

        return stack.pop();
    }
}
