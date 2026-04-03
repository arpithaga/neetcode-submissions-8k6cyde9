class Solution {
    public int evalRPN(String[] tokens) {
    Stack<Integer> deque = new Stack<>();
		
		for (String s : tokens) {
			if (s.matches("-?\\d+")) {
				deque.add(Integer.parseInt(s));
			} else {

				int n1 = deque.pop();
				int n2 = deque.pop();
				int total = 0;
				if (s.equals("+"))
					total = n1 + n2;
				else if (s.equals("-"))
					total = n2 - n1;
				else if (s.equals("/"))
					total = n2 / n1;
				else if (s.equals("*"))
					total = n1 * n2;

				deque.add(total);

			}
		}
		return deque.pop();
	
    }
}
