class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
		List<int[]> result = new ArrayList<>();
		
		int start =intervals[0][0];
		int end =intervals[0][1];
		int j=1;
		while(j<intervals.length)
		{
			if(intervals[j][0]<end) {
				end=Math.min(end, intervals[j][1]);
			}else {
				result.add(new int[] {start,end});
				start =intervals[j][0];
				end =intervals[j][1];
			}
			j++;
		
		}
		result.add(new int[] {start,end});
        return intervals.length-result.size();
    }
}
