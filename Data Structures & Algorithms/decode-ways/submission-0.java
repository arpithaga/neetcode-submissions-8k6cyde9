class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return numWays(0,s);
    }
    public int numWays(int n,String s) {        
        
        if(n==s.length()) return 1;
        if(n>s.length() || s.charAt(n)=='0') return 0;
        if(memo[n]!=-1) return memo[n];

        int num = numWays(n+1,s);

        if(n+1<s.length() && Integer.parseInt(s.substring(n,n+2))<=26)
            num+=numWays(n+2,s);

        return memo[n]=num; 
    }
}
