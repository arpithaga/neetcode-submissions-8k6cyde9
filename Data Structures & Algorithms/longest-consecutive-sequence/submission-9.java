class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0,count=0;
        for(int p:set){
            if(!set.contains(p-1)){
                count=1;
                int c=p;
                while(set.contains(c+1)){
                    count++;
                    c++;
                }
                max=Math.max(max,count);
            }
        }


        return max;
        
    }
}
