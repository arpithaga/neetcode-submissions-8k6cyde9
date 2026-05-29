class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r=new int[nums.length-k+1];
        Deque<Integer> pq=new ArrayDeque<>();
        int i=0,j=0,t=0;
        while(j<nums.length){

            while(!pq.isEmpty() && pq.peekFirst() < i) {
                pq.pollFirst();
            }
        	
        	while(!pq.isEmpty() && nums[pq.peekLast()]<=nums[j]) {
        		pq.pollLast();
        	}
        	
        	pq.offer(j);

        	if(j-i+1==k) {
        		r[t++]=nums[pq.peekFirst()];
        		i++;
        	}
        	
        	
        	j++;
        }

        return r;
    }
}