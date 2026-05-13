class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> counts=new HashMap<>();
		List<Integer>[] b=new List[nums.length+1];
		
		
		for(int i:nums) {
			counts.put(i,counts.getOrDefault(i, 0)+1);
		}
		for (int i = 0; i < b.length; i++) {
            b[i] = new ArrayList<>();
        }
		
        for(int i:counts.keySet()) {
        	b[counts.get(i)].add(i);
        }
        
        
        
        int[] r=new int[k];
        int c=0;
        for (int i = b.length - 1; i >= 0 && c < k; i--) {
    for (int q : b[i]) {
        r[c++] = q;
        if (c == k) return r;
    }
}
        
        return r;
    }
}
