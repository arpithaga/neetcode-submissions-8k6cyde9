class Solution {
    public int maxArea(int[] heights) {
        int maxArea=0;
        int i=0,j=heights.length-1;

        while(i<j){
            int l=heights[i];
            int r=heights[j];
            int a=Math.min(l,r)*(j-i);
            maxArea=Math.max(maxArea,a);

            if(heights[i]<heights[j]){
                while(i<j && heights[i]<=l){
                    i++;
                }
            }else{
                while(i<j && heights[j]<=r){
                    j--;
                }
            }
        }
        return maxArea;
    }
}
