class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] counts=new int[26];
		
		for(char c:tasks) {
			counts[c-'A']++;
		}
		int r=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		for (int cnt : counts) {
            if (cnt > 0) {
                pq.add(cnt);
            }
        }
		
		Queue<int[]> q=new ArrayDeque<>();
		while(!pq.isEmpty() || !q.isEmpty()) {
			r++;
			
			if(!pq.isEmpty()) {
				int k=pq.poll()-1;
				if(k>0)
				   q.add(new int[] {k,r+n});
			}
			
			if(!q.isEmpty() && q.peek()[1]==r) {
				pq.add(q.poll()[0]);
			}
			
		}
		
		
		return r;
    
    }
}
