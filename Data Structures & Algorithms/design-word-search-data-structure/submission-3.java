class Trie1{
    private boolean endOfWord;
    private Trie1[] children;
    
    public Trie1() {
    	endOfWord=false;
    	children= new Trie1[26];
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
class WordDictionary {
    Trie1 root;
    public WordDictionary() {
        root = new Trie1();
    }

    public void addWord(String word) {
        Trie1 curr =root;
        for(char c: word.toCharArray()){
            int index=c-'a';
            if(curr.getChildren()[index]==null){
                curr.getChildren()[index]=new Trie1();
            }
            curr=curr.getChildren()[index];
        }

        curr.setEndOfWord(true);
    }

    public boolean search(String word) {
		return searchInNode(root, 0, word);
	}

	private boolean searchInNode(Trie1 curr, int index, String word) {

		if (index == word.length())
			return curr.isEndOfWord();

		if (word.charAt(index) == '.') {
			for (Trie1 c : curr.getChildren()) {
				if (c != null) {
					if (searchInNode(c, index + 1, word))
						return true;
				}
			}

			return false;

		} else {
            int newIndex=word.charAt(index) - 'a';
			if (curr.getChildren()[newIndex] == null) {
				return false;
			}
			curr = curr.getChildren()[newIndex];
			return searchInNode(curr, index + 1, word);
		}

	}
}
