class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
		return dfsLongest(text1,text2,0,0,memo);
    }

	private int dfsLongest(String text1, String text2, int i, int j, Integer[][] memo) {
		
		if(i>=text1.length() || j>=text2.length()) return 0;
		
		if(memo[i][j]!=null) return memo[i][j];
		
		if(text1.charAt(i) == text2.charAt(j)) {
			memo[i][j] = 1+dfsLongest(text1,text2,i+1,j+1,memo);
		}else {
			memo[i][j] = Math.max(dfsLongest(text1,text2,i+1,j,memo),dfsLongest(text1,text2,i,j+1,memo));
		}
		
		return memo[i][j];
	}
}
