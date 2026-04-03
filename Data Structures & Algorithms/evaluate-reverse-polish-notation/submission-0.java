class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> stack = new Stack<>();

    for (String s : tokens) {
        if (s.matches("-?\\d+")) {
            stack.push(Integer.parseInt(s));
        } else {
            int n1 = stack.pop();
            int n2 = stack.pop();

            int result;
            if (s.equals("+"))
                result = n2 + n1;
            else if (s.equals("-"))
                result = n2 - n1;
            else if (s.equals("*"))
                result = n2 * n1;
            else
                result = n2 / n1;

            stack.push(result);
        }
    }
    return stack.pop();
    }
}
