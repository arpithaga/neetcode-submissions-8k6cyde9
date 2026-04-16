class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh=0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
					fresh++;
				}
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        int level=0;
		while (fresh>0 && !q.isEmpty()) {
        
        int len=q.size();
        for(int i=0;i<len;i++){
			int[] k = q.poll();
			int row = k[0];
			int col = k[1];

			for (int[] p : dir) {
				int r = row + p[0];
				int c = col + p[1];

				if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1) {
					grid[r][c] = 2;
                    fresh--;
					q.add(new int[] { r, c });
				}
            }
        }

        level++;

		}

        return fresh==0?level:-1;

    }
}
