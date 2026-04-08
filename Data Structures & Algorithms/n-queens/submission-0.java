class Solution {
    List<List<String>> result = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {

		result = new ArrayList<>();
		int[][] dp = new int[n][n];

		dfsFindQueens(dp, 0, n);

		return result;
	}

	private void dfsFindQueens(int[][] dp, int row, int n) {

		if (row == n) {
			addResult(dp);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (checkIfRowColNotqueen(dp, row, col, n)) {
				dp[row][col] = 1;
				dfsFindQueens(dp, row + 1, n);
				dp[row][col] = 0;
			}
		}

	}

	private boolean checkIfRowColNotqueen(int[][] dp, int row, int col, int n) {

		for (int i = 0; i < row; i++) {
			if (dp[i][col] == 1)
				return false;
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (dp[i][j] == 1)
				return false;
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (dp[i][j] == 1)
				return false;
		}

		return true;

	}

    private void addResult(int[][] dp) {
		List<String> r = new ArrayList<>();
		for (int[] k : dp) {

			StringBuilder sb = new StringBuilder();
			for (int q = 0; q < k.length; q++) {
				if (k[q] == 1) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			r.add(sb.toString());
		}
		result.add(r);
	}
}
