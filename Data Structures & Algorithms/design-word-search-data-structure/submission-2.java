class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.isEndOfWord = false;
	}
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

		for (char c : word.toCharArray()) {
			int i = c - 'a';
			if (curr.children[i] == null)
				curr.children[i] = new TrieNode();
			curr = curr.children[i];
		}
		curr.isEndOfWord = true;
    }

    public boolean search(String word) {

		TrieNode curr = root;
		return dfs(word, curr, 0);

	}

	private boolean dfs(String word, TrieNode curr, int i) {

		if (i == word.length())
			return curr.isEndOfWord;

		char c = word.charAt(i);
		if (c != '.') {
			int k = c - 'a';
			if (curr.children[k] == null)
				return false;
			curr = curr.children[k];
			return dfs(word, curr, i + 1);
		} else {
			for (TrieNode c1 : curr.children)
            if(c1!=null){
				if (dfs(word, c1, i + 1))
					return true;
            }
		}
		return false;
	}
}
