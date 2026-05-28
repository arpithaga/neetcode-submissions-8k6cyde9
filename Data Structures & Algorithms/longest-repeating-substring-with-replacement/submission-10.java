class Solution {
    public int characterReplacement(String s, int k) {
        int r=0;
        int i=0,j=0;
        int[] count=new int[26];
        int maxFreq=0;
        while(j<s.length()){
            
            count[s.charAt(j)-'A']++;
            
            maxFreq=Math.max(maxFreq, count[s.charAt(j)-'A']);
            
            while((j-i+1)-maxFreq>k) {
            	
            	count[s.charAt(i)-'A']--;
            	i++;
            	
            }
            
            r=Math.max(r, j-i+1);

            j++;
            
        }
        return r;
    }
    
}
