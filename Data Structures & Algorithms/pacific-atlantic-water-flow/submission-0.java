class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

		Set<List<Integer>> pacific = new HashSet<>();
		Set<List<Integer>> atlantic = new HashSet<>();

		for (int i = 0; i < heights.length; i++) {
			dfs(i, 0, heights, pacific);
		}

		for (int i = 0; i < heights[0].length; i++) {
			dfs(0, i, heights, pacific);
		}

		for (int i = 0; i < heights.length; i++) {
			dfs(i, heights[0].length - 1, heights, atlantic);
		}

		for (int i = 0; i < heights[0].length; i++) {
			dfs(heights.length - 1, i, heights, atlantic);
		}

		pacific.retainAll(atlantic);
        return new ArrayList<>(pacific);
	}

	private void dfs(int row, int col, int[][] heights, Set<List<Integer>> set) {

		List<Integer> cell = Arrays.asList(row, col);

        if (set.contains(cell)) return;

        set.add(cell);

		int[][] dir = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		for (int[] d : dir) {
			int r = row + d[0];
			int c = col + d[1];

			if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) {
				continue;
			}

			if (heights[r][c] >= heights[row][col]) {
				dfs(r, c, heights, set);
			}
		}

	}
}
