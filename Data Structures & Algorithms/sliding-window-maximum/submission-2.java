class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         int j=0;
        int[] r=new int[nums.length-k+1];
        int t=0;
        int w=0;
        ArrayDeque<Integer> deque1=new ArrayDeque<>();
        while(j<nums.length)
        {

            while(!deque1.isEmpty() && nums[j]>deque1.peekLast()){
                deque1.pollLast();
            }
            deque1.add(nums[j]);
            if(j-w+1==k)
            {
                if(!deque1.isEmpty()) {
                    r[t++] = deque1.peek();
                    if (nums[w] == deque1.peek()) {
                        deque1.pollFirst();
                    }
                    w++;
                }
            }
            j++;
        }

        return r;

    }
}
