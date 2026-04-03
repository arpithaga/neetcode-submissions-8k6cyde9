class Solution {
    public int findMin(int[] nums) {
        int minVal=Integer.MAX_VALUE;
        int i=0,j=nums.length-1;
        while(i<=j){

            if(nums[i]<nums[j]){
                minVal=Math.min(nums[i],minVal);
            }

            int mid=i+(j-i)/2;
            minVal=Math.min(minVal,nums[mid]);
            if(nums[i]<=nums[mid]){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }

        return minVal;
    }
}
