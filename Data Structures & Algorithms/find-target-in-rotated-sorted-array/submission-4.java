class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>nums[j]){
                i=mid+1;
            }else{
                j=mid-1;
            }
            
        }
        int pivot=i;
        int res=binarysearch(nums,target,0,pivot-1);

        if(res==-1)
           res=binarysearch(nums,target,pivot,nums.length-1);

        return res;
    }

    public int binarysearch(int[] nums,int target,int i,int j){
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
            
        }
        return -1;
    }
}
