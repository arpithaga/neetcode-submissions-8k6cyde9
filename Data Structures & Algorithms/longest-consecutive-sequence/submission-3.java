class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0)
          return 0;
       Set<Integer> set=new TreeSet<> ();
       for(int i:nums)
       {
        set.add(i);
       }

        int start=set.iterator().next();
        int count=1;
        int max=0;
       for(int p:set)
       {
         if(Math.abs(p-start)==1)
           count++;
         else if(Math.abs(p-start)!=0){
            max=Math.max(max,count);
        	 count=1;
             
         }
         start=p;
       }
    max=Math.max(max,count);
       return max;
    }
}
