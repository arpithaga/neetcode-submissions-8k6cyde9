class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length()>s.length()) return "";
        int[] freq=new int[128];
        for(char c:t.toCharArray())
        {
            freq[c]++;
        }

        int i=0,j=0;
        int needed=t.length();
        int minIndex=-1;
        int min1=Integer.MAX_VALUE;
        while(j<s.length())
        {
            char c=s.charAt(j);
            if(freq[c]>0){
                needed--;
            }
            freq[c]--;
            j++;
                while(needed==0) {
                    if (j - i < min1) {
                        min1 = j - i;
                        minIndex = i;
                    }
                    if (freq[s.charAt(i)] >= 0) {
                        needed++;
                    }
                    freq[s.charAt(i)]++;
                    i++;
                }
        }

        return minIndex==-1?"":s.substring(minIndex,minIndex+min1);

    }
}
