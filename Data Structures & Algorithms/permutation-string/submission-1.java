class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts=new int[26];
        for(char c:s1.toCharArray()){
            counts[c-'a']++;
        }
        int[] counts2= counts.clone();
        int i=0,j=0;
        while(j<s2.length()){
            if(counts[s2.charAt(j)-'a']>=1)
            {
                counts[s2.charAt(j)-'a']--;
                if(j-i+1==s1.length())
                    return true;
            }else{
                counts=counts2.clone();
                j=i;
                i++;
            }

            j++;
        }

        return false;
    }
}