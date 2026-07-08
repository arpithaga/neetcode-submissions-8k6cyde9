class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

		boolean[][] pacific = new boolean[heights.length][heights[0].length];
		boolean[][] atlantic = new boolean[heights.length][heights[0].length];

		for (int i = 0; i < heights.length; i++) {
			dfs(heights,pacific,i,0,Integer.MIN_VALUE);
			dfs(heights,atlantic,i,heights[0].length-1,Integer.MIN_VALUE);
		}

		for (int i = 0; i < heights[0].length; i++) {
			dfs(heights,pacific,0,i,Integer.MIN_VALUE);
			dfs(heights,atlantic,heights.length-1,i,Integer.MIN_VALUE);
		}
        
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					result.add(List.of(i, j));
				}
			}
		}

		return result;
	}

	private void dfs(int[][] heights, boolean[][] ocean, int row, int col, int curr) {

		// from a cell to a neighboring cell with height equal or lower.
		if (row >= heights.length || col >= heights[0].length || row < 0 || col < 0 || heights[row][col] < curr || ocean[row][col]) {
			return;
		}

		ocean[row][col]=true;
		dfs(heights, ocean, row + 1, col, heights[row][col]);
		dfs(heights, ocean, row, col + 1, heights[row][col]);
		dfs(heights, ocean, row - 1, col, heights[row][col]);
		dfs(heights, ocean, row, col - 1, heights[row][col]);
		
	}
}
