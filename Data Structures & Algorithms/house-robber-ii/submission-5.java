class Solution {
	int[] memo;
	public int rob(int[] nums) {
		if(nums.length==1) return nums[0];
		memo = new int[nums.length];
		Arrays.fill(memo,-1);
        int rob1 = rob(nums.length-1,nums,1);
        Arrays.fill(memo,-1);
		return Math.max(rob1,rob(nums.length-2,nums,0));
    }

	private int rob(int n, int[] nums,int l) {
		if(n<l) return 0;
		if(memo[n]!=-1) return memo[n];
		return memo[n]=Math.max(nums[n]+rob(n-2,nums,l),rob(n-1,nums,l));
	}
}
