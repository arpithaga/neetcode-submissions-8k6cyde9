class TrieNode {
	TrieNode[] children;
	int index;
	boolean isEndOfWord;

	public TrieNode() {
		super();
		this.children = new TrieNode[26];
		this.isEndOfWord = false;
		index = -1;
	}

}

public class Solution {

	List<String> result = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {

		TrieNode root = new TrieNode();

		for (int i = 0; i < words.length; i++) {
			TrieNode curr = root;
			for (int j = 0; j < words[i].length(); j++) {
				int k = words[i].charAt(j) - 'a';
				TrieNode c = curr.children[k];

				if (c == null) {
					curr.children[k] = new TrieNode();
				}
				curr = curr.children[k];
			}

			curr.isEndOfWord = true;
			curr.index = i;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.children[board[i][j] - 'a'] != null)
					dfs(board, words, root, i, j);
			}
		}

		return result;
	}

	private void dfs(char[][] board, String[] words, TrieNode current, int row, int col) {

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			return;
		}
		
		char ch = board[row][col];
		if (ch == '#') return;


		int k = board[row][col] - 'a';
		
		if (current.children[k] == null) return;
		current = current.children[k];
		if (current != null && current.index != -1 && current.isEndOfWord == true) {
			result.add(words[current.index]);
			current.index = -1;
		}
		
		char temp = board[row][col];
		board[row][col] = '#';

		dfs(board, words, current, row + 1, col);
		dfs(board, words, current, row, col + 1);
		dfs(board, words, current, row - 1, col);
		dfs(board, words, current, row, col - 1);

		board[row][col] = temp;

	}
}
