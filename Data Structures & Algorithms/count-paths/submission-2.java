class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m+1];
        dp[1]=1;

        for(int j=1;j<=n;j++){
            for(int i=1;i<=m;i++){
                dp[i]=dp[i]+dp[i-1];
            }
        }


        return dp[m];
    }
}
