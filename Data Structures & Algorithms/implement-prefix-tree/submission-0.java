class TrieNode{
    private TrieNode[] children;
    boolean isEndOfWord;
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class PrefixTree {

    private TrieNode root;
    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
         TrieNode curr=root;

         for(char c:word.toCharArray()){
            int i=c-'a';
            if(curr.children[i]==null){
                curr.children[i]=new TrieNode();
            }
            curr=curr.children[i];
         }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr=root;

         for(char c:word.toCharArray()){
            int i=c-'a';
            if(curr.children[i]==null){
                return false;
            }
            curr=curr.children[i];
         }

         return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr=root;

         for(char c:prefix.toCharArray()){
            int i=c-'a';
            if(curr.children[i]==null){
                return false;
            }
            curr=curr.children[i];
         }

        return true;
    }
}
