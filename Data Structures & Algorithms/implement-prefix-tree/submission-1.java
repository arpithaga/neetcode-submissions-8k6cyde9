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

class PrefixTree {
	
	Trie1 root;
    public PrefixTree() {
        root=new Trie1(); 
    }

    public void insert(String word) {
    	Trie1 curr=root;
    	for(char c: word.toCharArray()) {
    		int index = c-'a';
    		if(curr.getChildren()[index]==null) {
    			curr.getChildren()[index]=new Trie1();
    		}
    		curr=curr.getChildren()[index];
    	}
    	curr.setEndOfWord(true);
    }

    public boolean search(String word) {
    	Trie1 curr=root;
    	for(char c: word.toCharArray()) {
    		if(curr.getChildren()[c-'a']==null) return false;
    		curr=curr.getChildren()[c-'a'];
    	}
    	return curr.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
    	
    	Trie1 curr=root;    	
    	for(char c: prefix.toCharArray()) {
    		if(curr.getChildren()[c-'a']==null) return false;
    		curr=curr.getChildren()[c-'a'];
    	}
    	return true;
    }
}
