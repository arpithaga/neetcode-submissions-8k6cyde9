class KthLargest {

    PriorityQueue<Integer> numsList;
	int k = -1;

	public KthLargest(int k, int[] nums) {
		
		this.numsList=new PriorityQueue<>();
		for(int i=0;i<nums.length;i++) {
			numsList.offer(nums[i]);
			if(numsList.size()>k) {
				numsList.poll();
			}
			
		}
		this.k = k;
	}

	public int add(int val) {
		numsList.offer(val);
		if(numsList.size()>k) {
			numsList.poll();
		}
		return numsList.peek();
	}
}
