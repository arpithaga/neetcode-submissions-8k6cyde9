class Solution {
    int maxSubSeq=0;
    Integer[][] memo;
    public int lengthOfLIS(int[] nums) {
        maxSubSeq=0;
        memo=new Integer[nums.length][nums.length+1];    
        return dfsCheckLongestLIS(nums,0,-1);
    }

    public int dfsCheckLongestLIS(int[] nums,int index,int prevIndex){
        if(index>=nums.length) return 0;

        if(memo[index][prevIndex+1] != null) return memo[index][prevIndex+1];
        int take=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            take = 1+dfsCheckLongestLIS(nums,index+1,index);
        }

        int skip=dfsCheckLongestLIS(nums,index+1,prevIndex);
        return memo[index][prevIndex+1]=Math.max(take,skip);
    }
}
