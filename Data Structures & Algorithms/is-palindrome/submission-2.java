class Solution {
    public boolean isPalindrome(String s) {
        
        int i=0;
        int j=s.length()-1;
        while(i<j && i<s.length() && j>=0)
        {
            while(i<s.length() && !(Character.isDigit(s.charAt(i))||Character.isLetter(s.charAt(i)))) 
              i++;

            while(j>=0 && !(Character.isDigit(s.charAt(j))||Character.isLetter(s.charAt(j)))) 
              j--;
            
              
              if(i<s.length() && j>=0 && !s.substring(i,i+1).equalsIgnoreCase(s.substring(j,j+1)))
              {
                    return false;
              }
              
              i++;
              j--;
        }
     
		return true;
    }
}
