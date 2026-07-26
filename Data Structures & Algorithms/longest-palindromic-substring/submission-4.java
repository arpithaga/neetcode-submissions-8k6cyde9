class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String word= "";
        for(int i=0;i<s.length();i++){
            int c1 = longest(i,i,s);
            int c2 = longest(i,i+1,s);

            int c=Math.max(c1,c2);

            if(c>maxLen){
                maxLen = c;
                word= s.substring(i-(c-1)/2,i+c/2+1);
            }

        }

        return word;
    }

    public int longest(int l, int r, String s) {
         while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;r++;
        }

        return r-l-1;       
    }
}
