class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
		int maxArea=0;
		for(int i=0;i<=heights.length;i++){
			int curr= i<heights.length?heights[i]:0;
			while(!stack.isEmpty() && heights[stack.peek()]>curr){
				int height=heights[stack.pop()];
				int width= stack.isEmpty()?i:i-stack.peek()-1;
				int area=height*width;
				maxArea = Math.max(maxArea,area);
			}

			stack.push(i);
		}

		return maxArea;
    }
}
