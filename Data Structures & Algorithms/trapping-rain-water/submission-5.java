class Solution {
    public int trap(int[] height) {
       if(height==null||height.length<=2)
		{
			return 0;
		}
		
		int l=0,r=height.length-1;
		int lm=height[l],rm=height[r];
		
		
		int res=0;
		while(l<r)
		{
			if(lm<rm)
			{
				l++;
				lm=Math.max(lm, height[l]);
				res+=lm-height[l];
			}else {
				r--;
				rm=Math.max(rm, height[r]);
				res+=rm-height[r];
			}
		}
		
		
		return res;
    }
}
