class Solution {
    public int maxArea(int[] heights) {
        int i=0,j=heights.length-1;
        int max=0;
        while(i<j)
        {
           int water=(j-i)*Math.min(heights[i],heights[j]);
           max=Math.max(water,max);
           if(heights[i]<heights[j])
            i++;
           else
            j--; 
        }

        return max;
    }
}
