class Solution {
    public String minWindow(String s, String t) {
        int[] counts=new int[128];
        for(char c:t.toCharArray()){
            counts[c]++;
        }
        
        int i=0,j=0;
        int minStart=-1;
        int minWindow=Integer.MAX_VALUE;
        
        int req=t.length();
        while(j<s.length()){
            char a=s.charAt(j);
            
            if(counts[a]>0)
            	req--;
            
            counts[a]--;

            

            while(req==0){
               if(j-i+1<minWindow){
                    minWindow=j-i+1;
                    minStart=i;
               }
               counts[s.charAt(i)]++;  
               
               if(counts[s.charAt(i)]>0)
               	req++;
               
               i++;
            }
            
            j++;

        }

        return minWindow==Integer.MAX_VALUE?"":s.substring(minStart, minStart+minWindow);
    
    }
}
