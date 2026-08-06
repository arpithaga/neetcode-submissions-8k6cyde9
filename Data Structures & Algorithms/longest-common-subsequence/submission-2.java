class Solution {
    
	public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
		return dfsCommonSub(text1,text2,0,0,memo);
    }

	private int dfsCommonSub(String text1, String text2, int i, int j, Integer[][] memo) {
		
		if(i>=text1.length() || j>=text2.length()) {
			return 0;
		}

        if(memo[i][j] != null) return memo[i][j];

		if(text1.charAt(i) == text2.charAt(j)) {
			return memo[i][j]=1+dfsCommonSub(text1,text2,i+1,j+1,memo);
		}else{
        	return memo[i][j]=Math.max(dfsCommonSub(text1,text2,i+1,j,memo),dfsCommonSub(text1,text2,i,j+1,memo));
	}
    }
}
