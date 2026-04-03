class Solution {
    public int lengthOfLongestSubstring(String s) {

      if(s.length()<=1)
        return s.length();
      int l=0;
      int r=l+1;
      int max=0;
      Set<Character> set=new HashSet<>();
        while(l<s.length())
        {
            r=l;
            while(r<s.length())
            {
                if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
               }else{
                set=new HashSet<>();
                break;
               }
            }
            max=Math.max(max,r-l);
            l++;
        }
        return max;
    }
}
