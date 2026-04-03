class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l=0,r=height.length-1;
        int lMax=height[l],rMax=height[r];       
        int sum=0;
        while(l<r)
        {
            if(lMax<rMax)
            {
                l++;
                lMax=Math.max(lMax,height[l]);
                sum+=lMax-height[l];
                
                
            }else
            {
                r--;
                rMax=Math.max(rMax,height[r]);
                sum+=rMax-height[r];
                
            }
        }
        return sum;
    }
}
