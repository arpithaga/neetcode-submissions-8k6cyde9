class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts=new int[26];
        for(char c:s1.toCharArray()){
            counts[c-'a']++;
        }

        int i=0,j=0;
        while(j<s2.length()){
            char a=s2.charAt(j);
            counts[a-'a']--;

            while(counts[a-'a']<0){
                counts[s2.charAt(i)-'a']++;
                i++;
            }

            if(j-i+1==s1.length())
               return true;

            j++;

        }

        return false;
    }
}
