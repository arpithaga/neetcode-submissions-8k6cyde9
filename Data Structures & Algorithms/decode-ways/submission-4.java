class Solution {
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()+1];
        Arrays.fill(memo,-1);
        return countWays(0,s);
    }

    public int countWays(int index, String s){

        if(index == s.length()) return 1;

        if(index> s.length() || s.charAt(index)=='0') return 0;

        if(memo[index] != -1) return memo[index];

        int total = countWays(index+1,s);

        if(index+1<s.length() && Integer.parseInt(s.substring(index,index+2))<=26){
            total += countWays(index+2,s);
        }

        return memo[index]=total;
        
    }
}
