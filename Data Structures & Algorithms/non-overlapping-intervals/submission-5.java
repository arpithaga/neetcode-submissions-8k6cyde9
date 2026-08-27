class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
		
		int start =intervals[0][0];
		int end =intervals[0][1];
        int removal=0;
		int j=1;
		while(j<intervals.length)
		{
			if(intervals[j][0]<end) {
                removal++;
				end=Math.min(end, intervals[j][1]);
			}else {			
				start =intervals[j][0];
				end =intervals[j][1];
			}
			j++;
		
		}
        return removal;
    }
}
