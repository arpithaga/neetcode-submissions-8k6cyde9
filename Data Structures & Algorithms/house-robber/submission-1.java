class Solution {
   
   int[] memo;
   public int rob(int[] nums) {
		memo = new int[nums.length];
        return rob(nums.length-1,nums);
    }

	private int rob(int n, int[] nums) {		
		if(n<0) return 0;
		if(memo[n]!=0) return memo[n];
		return memo[n]=Math.max(nums[n]+rob(n-2,nums),rob(n-1,nums));
	}
}
