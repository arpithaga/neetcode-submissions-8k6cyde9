class Solution {
	public int rob(int[] nums) {
		if(nums.length==1) return nums[0];
        int rob1 = rob(nums,1,nums.length-1);
		return Math.max(rob1,rob(nums,0,nums.length-2));
    }

	private int rob(int[] nums, int start,int end) {
		
		int prev=0,next=0;
		for(int i=start;i<=end;i++) {
			int temp=Math.max(nums[i]+prev, next);
			prev=next;
			next=temp;
		}
		
		return next;
	}
}
