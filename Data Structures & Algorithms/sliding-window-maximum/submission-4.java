class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r=new int[nums.length-k+1];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        int i=0,j=0,t=0;
        while(j<nums.length){
        	
        	pq.add(new int[]{j,nums[j]});
            if(j-i+1==k){
            	while(pq.peek()[0]<i){
                    pq.poll();
                }

                r[t++]=pq.peek()[1];
                i++;
            }
            
            j++;
        }

        return r;
    }
}
