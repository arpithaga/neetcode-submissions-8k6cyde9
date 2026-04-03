class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray())
        {

            if(c==')'||c=='}'||c==']')
            {
                if(!stack.isEmpty())
                {
                    char o=stack.pop();
                    if(c==')' && o!='(') return false;
                    else if(c==']' && o!='[') return false;
                    else if(c=='}' && o!='{') return false;
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
