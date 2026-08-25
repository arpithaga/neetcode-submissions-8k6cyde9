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
    public boolean canAttendMeetings(List<Interval> intervals) {
		Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
		int end=-1;

		for(int i=0;i<intervals.size();i++){
			if(intervals.get(i).start<end)
			  return false;

			end=intervals.get(i).end;
		}

		return true;
    }
}
