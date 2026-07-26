class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for(int i=0;i<s.length();i++){
            count += returnCount(i,i,s);
            count += returnCount(i,i+1,s);
        }

        return count;
    }

    public int returnCount(int l, int r, String s) {
        int count=0;
         while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                l--;r++;
        }

        return count;       
    }
}
