class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> counts=new HashMap<>();
		
		PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
		
		for(int i:nums) {
			counts.put(i,counts.getOrDefault(i, 0)+1);
		}
		
        for(int i:counts.keySet()) {
        	q.add(new int[] {i,counts.get(i)});
        	if(q.size()>k) {
        		q.poll();
        	}
        }
        
        return q.stream().map(a->a[0]).mapToInt(Integer::intValue).toArray(); 
    }
}
