/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {	

        if(intervals==null || intervals.isEmpty()) return 0;

		int count=1;
		
		List<Integer> start = new ArrayList<>();
		List<Integer> end = new ArrayList<>();
		
		Collections.sort(intervals,(a,b)->Integer.compare(a.start, b.start));
		
		for(Interval i: intervals) {
			start.add(i.start);
			end.add(i.end);
		}

        Collections.sort(start);
        Collections.sort(end);
		
		int i=1,j=0;
		
		while(i<start.size()) {
			if(start.get(i)<end.get(j)) {
				count++;
			}else {
				j++;
			}
			
			i++;
		}
		
		return count;
		
    }
}
