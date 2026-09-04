class Solution {
    public int largestRectangleArea(int[] heights) {
       int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= heights.length; i++) {
			int current= (i==heights.length)?0:heights[i];
			while(!stack.isEmpty() && heights[stack.peek()]>current) {
				int height=heights[stack.pop()];            
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                int area = height * width;
                maxArea = Math.max(maxArea, area);
			}		
			stack.push(i);			
		}

		return maxArea;
    }
}
