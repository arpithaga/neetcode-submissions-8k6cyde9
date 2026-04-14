class Solution {
    public void islandsAndTreasure(int[][] grid) {

		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					q.add(new int[] { i, j });
				}
			}
		}

		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		while (!q.isEmpty()) {

			int[] k = q.poll();
			int row = k[0];
			int col = k[1];

			for (int[] p : dir) {
				int r = row + p[0];
				int c = col + p[1];

				if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == Integer.MAX_VALUE) {
					grid[r][c] = grid[row][col] + 1;
					q.add(new int[] { r, c });
				}
			}

		}

	}
}
