class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top=0;
        for(char c: s.toCharArray()){
            if(c=='}' && (stack.length==0 || top<=0 || stack[--top]!='{')){
                return false;
            }
            if(c==')' && (stack.length==0 || top<=0 || stack[--top]!='(')){
                return false;
            }
            if(c==']' && (stack.length==0 || top<=0 || stack[--top] !='[')){
                return false;
            }
            if (c=='{' || c=='('|| c=='['){
            	stack[top++]=c; 
            }
        }

        return top==0;
    }
}
