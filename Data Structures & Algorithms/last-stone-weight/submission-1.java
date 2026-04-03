class Solution {
    public int lastStoneWeight(int[] stones) {

      PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
      for(int p:stones){
        q.offer(p);
      }

      while(q.size()>1){
        int l1=q.poll();
        int l2=q.poll();

        q.offer(Math.abs(l1-l2));
      }

      return q.isEmpty() ? 0 : q.peek();
        
    }
}
