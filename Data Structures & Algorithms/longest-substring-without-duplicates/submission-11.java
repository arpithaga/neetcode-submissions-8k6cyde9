class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int max=0;
        Set<Character> set=new HashSet<>();
        while(j<s.length())
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
            }else{
                while(i<j)
                {                    
                    if(s.charAt(i)==s.charAt(j))
                    {
                        i++;
                        break;
                    }
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            max=Math.max(max,j-i+1);
            j++;
        }

        return max;
    }
}
