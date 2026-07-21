class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;

		for (int i = 0; i <= amount; i++) {
			if (dp[i] != -1) {
				for (int p : coins) {
					if ((long)i + p > amount)
						continue;
					dp[i + p] = Math.min(dp[i + p], dp[i] + 1);
				}
			}
		}

		return dp[amount]>amount?-1:dp[amount];

    }
}
