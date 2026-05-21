class Solution {
    public int trap(int[] height) {
        int[] prefixMax=new int[height.length];
        int max1=0;
        for(int i=0;i<height.length;i++){
            prefixMax[i]=Math.max(max1,height[i]);
            max1=Math.max(max1,height[i]);
        }

        int[] suffixMax=new int[height.length];
        max1=0;
        for(int i=height.length-1;i>=0;i--){
            suffixMax[i]=Math.max(max1,height[i]);
            max1=Math.max(max1,height[i]);
        }

        int sum=0;
        for(int i=0;i<height.length;i++){
            int w=Math.min(prefixMax[i],suffixMax[i])-height[i];
            if(w<0) w=0;
            sum+=w;
        }


        return sum;
    }
}
