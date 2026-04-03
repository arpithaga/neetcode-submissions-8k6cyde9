class Solution {
    public int largestRectangleArea(int[] heights) {   
        		int maxArea = 0;

		Deque<int[]> stack = new ArrayDeque<>();
		for (int i = 0; i < heights.length; i++) {
			int start=i;
			int height=heights[i];
			while(!stack.isEmpty() && stack.peek()[1]>=height) {
				int[] r=stack.pop();
				maxArea=Math.max(maxArea, r[1]*(i-r[0]));
				start=r[0];
			}
			
			
			stack.push(new int[] { start, heights[i] });
		}
		
		while(!stack.isEmpty()) {
			int[] r=stack.pop();
			maxArea=Math.max(maxArea, r[1]*(heights.length-r[0]));
		}

		return maxArea;
    }
}
