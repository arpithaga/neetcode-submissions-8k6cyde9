class MedianFinder {

    PriorityQueue<Integer> minq = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> maxq = new PriorityQueue<>();

	public MedianFinder() {
		minq = new PriorityQueue<>(Collections.reverseOrder());
	    maxq = new PriorityQueue<>();
	}

	public void addNum(int num) {

		// Step 1: add to left
        minq.add(num);

        // Step 2: move max of left → right
        maxq.add(minq.poll());

        // Step 3: balance sizes
        if (maxq.size() > minq.size()) {
            minq.add(maxq.poll());
        }

	}

	public double findMedian() {
		int s1 = minq.size();
		int s2 = maxq.size();

		if (s1 > s2) {
			return minq.peek();
		} else if(s2>s1) {
			return maxq.peek();
		}

		return (maxq.peek() + minq.peek()) / 2.0;

	}
}
