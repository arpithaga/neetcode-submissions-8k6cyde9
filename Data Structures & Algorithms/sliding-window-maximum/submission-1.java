class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int maxIndex=-1,maxValue=Integer.MIN_VALUE;
        int j=0;
        int[] r=new int[nums.length-k+1];
        int t=0;
        int w=0;
        while(j<nums.length)
        {

            if(nums[j]>maxValue){
                maxValue=nums[j];
                maxIndex=j;
            }

            if(j-w+1==k)
            {
                r[t++]=maxValue;
                if(w==maxIndex)
                {
                    j=w;
                    maxIndex=-1;
                    maxValue=Integer.MIN_VALUE;
                }
                w++;
            }
            j++;
        }

        return r;
    }
}
