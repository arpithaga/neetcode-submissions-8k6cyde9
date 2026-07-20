class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;

        for(int i=0;i<=amount;i++){
            if(dp[i]!=-1){
                for( int p:coins){
                    long nextAmountLong = (long)i + p;
                    if(nextAmountLong > amount) continue;
                    int a = (int)nextAmountLong;
                    if (dp[a] == -1 || dp[a] > dp[i] + 1) {
                        dp[a]=dp[i]+1;
                    }
                }
            }
        }

        return dp[amount];

    }
}
