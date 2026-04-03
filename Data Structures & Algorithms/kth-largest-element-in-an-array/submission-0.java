class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int p : nums) {
			q.offer(p);
			if (q.size() > k) {
				q.poll();
			}
		}

		return q.peek();
    }
}
