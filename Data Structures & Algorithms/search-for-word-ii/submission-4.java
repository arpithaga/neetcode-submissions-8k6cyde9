class Trie1 {
	private boolean endOfWord;
	private Trie1[] children;
	public String word;

	public Trie1() {
		endOfWord = false;
		children = new Trie1[26];
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

	public Trie1[] getChildren() {
		return children;
	}

	public void setChildren(Trie1[] children) {
		this.children = children;
	}
}

class Solution {
    Trie1 root;

	public Solution() {
		root = new Trie1();
	}

	public void insert(String word) {
		Trie1 curr = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (curr.getChildren()[index] == null) {
				curr.getChildren()[index] = new Trie1();
			}
			curr = curr.getChildren()[index];
		}
		curr.setEndOfWord(true);
		curr.word=word;
	}
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
		for (String w : words) {
			insert(w);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (root.getChildren()[board[i][j] - 'a'] != null) {
					findWordBackTrack(board, i, j, root);
				}
			}
		}

		return result;
	}

	private void findWordBackTrack(char[][] board, int i, int j, Trie1 curr) {

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}

		char ch = board[i][j];
		if (ch=='#' || curr.getChildren()[ch - 'a'] == null)
			return;

        curr = curr.getChildren()[ch - 'a'];
		if (curr.isEndOfWord()) {
			result.add(curr.word);
			curr.setEndOfWord(false);
		}
		
		board[i][j]='#';
		findWordBackTrack(board,i+1,j,curr);
		findWordBackTrack(board,i,j+1,curr);
		findWordBackTrack(board,i-1,j,curr);
		findWordBackTrack(board,i,j-1,curr);
		board[i][j]=ch;
	}
}
