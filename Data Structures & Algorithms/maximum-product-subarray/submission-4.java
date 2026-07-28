class Solution {
    public int maxProduct(int[] nums) {
        int maxTotal=nums[0];
        int minFound=nums[0];
        int maxFound=nums[0];

        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            if(nums[i]<0){
                int temp=minFound;
                minFound=maxFound;
                maxFound=temp;
            }

            minFound=Math.min(curr,curr*minFound);
            maxFound=Math.max(curr,curr*maxFound);

            maxTotal=Math.max(maxTotal,maxFound);

        }

        return maxTotal;
    }
}
