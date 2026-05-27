class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r=0;
        int i=0,j=0;
        int[] counts=new int[128];
        while(j<s.length()){
            counts[s.charAt(j)]++;
            while(counts[s.charAt(j)]>1){
                    counts[s.charAt(i)]--;
                    i++;
            }
            r=Math.max(r,j-i+1);
            j++;
        }
        return r;
    }
}
