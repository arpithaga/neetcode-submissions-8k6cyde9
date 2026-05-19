class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0,count=0;
        for(int p:nums){
            count=0;
            if(!set.contains(p-1)){
                while(set.contains(p)){
                    count++;
                    p++;
                    max=Math.max(max,count);
                }
            }
        }


        return max;
        
    }
}
