class Solution {
    public int[][] kClosest(int[][] points, int k) {

    PriorityQueue<int[]> q = new PriorityQueue<>(
      (a, b) -> {
        int distA = a[0] * a[0] + a[1] * a[1];
        int distB = b[0] * b[0] + b[1] * b[1];
        return Integer.compare(distB, distA);
      }
    );

		for (int[] p : points) {
			q.offer(p);
			if (q.size() > k) {
				q.poll();
			}
		}

		return q.toArray(new int[q.size()][2]);  


    }
}
