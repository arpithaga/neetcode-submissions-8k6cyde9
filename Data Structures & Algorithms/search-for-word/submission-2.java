class Solution {
    public boolean exist(char[][] board, String word) {
		int index = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (backTrack(board, i, j, index, word))
						return true;
				}
			}
		}
		return false;
	}

	private boolean backTrack(char[][] board, int i, int j, int index, String word) {
		
		if(index==word.length()) return true;

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j]!=word.charAt(index)) {
			return false;
		}
		
		char temp=board[i][j];
		board[i][j]='#';
		
		boolean found= backTrack(board, i + 1, j, index + 1, word) ||
			   backTrack(board, i - 1, j, index + 1, word) ||
			   backTrack(board, i, j+1, index + 1, word) ||
			   backTrack(board, i, j-1, index + 1, word);
		
		board[i][j]=temp;

		return found;

	}
}
