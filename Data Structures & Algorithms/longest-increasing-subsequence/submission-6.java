class Solution {

    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {

        dp=new Integer[nums.length][nums.length+1];
        return dpgetLongSeq(nums,0,-1);
    }

    public int dpgetLongSeq(int[] nums,int index,int prevIndex){
        if(index >= nums.length) return 0;

        if(dp[index][prevIndex+1] != null) return dp[index][prevIndex+1];

        int take = 0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            take = 1 + dpgetLongSeq(nums,index+1,index);
        }

        int skip = dpgetLongSeq(nums,index+1,prevIndex);

        return dp[index][prevIndex+1]=Math.max(skip,take);

    }
}
