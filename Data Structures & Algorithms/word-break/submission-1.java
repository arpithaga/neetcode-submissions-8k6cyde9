class TrieNode{
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode(){
        children = new TrieNode[26];
    }
}

class Solution {
    TrieNode root;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();

        for(String c: wordDict){
            insert(root,c);
        }

        memo = new Boolean[s.length()];

        return checkWord(s,0);

    }

    public boolean checkWord(String s, int start){
        
        if(start==s.length()) return true;

        if(memo[start]!=null) return memo[start];

        TrieNode curr=root;
        for(int i=start;i<s.length();i++){
            int index = s.charAt(i)-'a';

            if(curr.children[index]==null){
                break;
            }

            curr=curr.children[index];

            if(curr.isEndOfWord){
                if(checkWord(s,i+1)){
                    return memo[start]=true;
                }
            }

        }


        return memo[start]=false;
    }

    public void insert(TrieNode curr, String s){
        for(char c: s.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEndOfWord=true;
    }

}
