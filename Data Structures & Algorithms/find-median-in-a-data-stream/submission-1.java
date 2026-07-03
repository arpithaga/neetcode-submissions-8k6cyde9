class MedianFinder {

    PriorityQueue<Integer> left= new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Integer> right= new PriorityQueue<>();
	
	public MedianFinder() {		
		left= new PriorityQueue<>(Collections.reverseOrder());
		right= new PriorityQueue<>();	        
	}

	public void addNum(int num) {
		if(left.isEmpty()|| left.peek()>=num) {
			left.add(num);
		}else {
			right.add(num);
		}
		
		while(left.size()>right.size()+1) {
			right.add(left.poll());
		}
		
		while(right.size()>left.size()) {
			left.add(right.poll());
		}
	}

	public double findMedian() {
		int s1=left.size();
		int s2=right.size();
		
		if(s1>s2) {
			return left.peek();
		}else if(s2>s1) {
			return right.peek();
		}
		return (left.peek()+right.peek())/2.0;

	}
}