class Solution {
    public boolean checkInclusion(String s1, String s2) {
    if(s1.length()>s2.length()) return false;

    int[] freq=new int[26];
    for(char c:s1.toCharArray())
    {
        freq[c-'a']++;
    }
    int i=0,j=0;
    int needed=s1.length();
    while(j<s2.length())
    {
        if(freq[s2.charAt(j)-'a']>0)
        {
            needed--;
        }

        freq[s2.charAt(j)-'a']--;
        j++;

        if(needed==0) return true;

        if(j-i==s1.length())
        {
            if(freq[s2.charAt(i)-'a']>=0){
                needed++;
            }

            freq[s2.charAt(i)-'a']++;
            i++;
        }
    }
    return false;
}

}