class Solution {
    public boolean isAnagram(String s, String t) {
        int[] present=new int[26];

        for(char c:t.toCharArray())
        {
            present[c-'a']++;
        }
        
        for(char c:s.toCharArray())
        {
            
               present[c-'a']--;
        }

        for(int p:present)
        {
            if(p!=0)
            {
                return false;
            }
        }

        return true;

    }
}
