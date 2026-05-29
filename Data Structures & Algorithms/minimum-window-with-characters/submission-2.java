class Solution {
    public String minWindow(String s, String t) {

        int[] counts=new int[128];
        for(char c:t.toCharArray()){
            counts[c]++;
        }

        int req=t.length();
        int i=0,j=0;
        int start=-1;
        int minWindow=Integer.MAX_VALUE;
        while(j<s.length()){

            if(counts[s.charAt(j)]>0)
              req--;

            counts[s.charAt(j)]--;
            
            while(req==0){
                if(j-i+1<minWindow){
                    minWindow=j-i+1;
                    start=i;
                }

                counts[s.charAt(i)]++;

                if(counts[s.charAt(i)]>0)
                    req++;
                i++;
            }


            j++;
        }      
        return minWindow==Integer.MAX_VALUE?"":s.substring(start,start+minWindow);
    }
}
