class Solution {
    public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}

		return false;

	}

	private boolean dfs(char[][] board, String word, int i, int row, int column) {

        if (i == word.length())
			return true;

		if (row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] != word.charAt(i)) {
			return false;
		}
		
		char temp=board[row][column];
		board[row][column]='#';
		boolean 
			found=dfs(board, word, i + 1, row + 1, column)||
			dfs(board, word, i + 1, row, column + 1)||
			dfs(board, word, i + 1, row - 1, column)||
			dfs(board, word, i + 1, row, column - 1);
		
		
		board[row][column]=temp;
		return found;

	}
}
