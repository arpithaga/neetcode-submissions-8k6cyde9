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

class Solution {
    TrieNode root;
	Boolean[] memob;

	public boolean wordBreak(String s, List<String> wordDict) {
		root = new TrieNode();
		memob = new Boolean[s.length() + 1];

		for (String w : wordDict) {
			insert(root, w);
		}

		return checkWord(root, s, 0);
	}

	private Boolean checkWord(TrieNode curr, String s, int start) {

		if (start == s.length()) {
			return true;
		}

		if (memob[start] != null) {
			return memob[start];
		}
		
		TrieNode node=curr;
		for (int i = start; i < s.length(); i++) {

			int index = s.charAt(i) - 'a';

			if (node.children[index] == null)
				break;

			node = node.children[index];

			if (node.isEndOfWord) {
				if (checkWord(curr, s, i + 1)) {
					return memob[start] = true;
				}
			}

		}

		return memob[start] = false;
	}

    private void insert(TrieNode curr, String s) {

		for (char c : s.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new TrieNode();
			}
			curr = curr.children[c - 'a'];
		}
		curr.isEndOfWord = true;

	}
}
