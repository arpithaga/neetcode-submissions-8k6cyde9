class Solution {
    public String longestPalindrome(String s) {
		
		int index=-1;
		int maxLen=0;
		
		for(int i=0;i<s.length();i++) {
			
			//odd
			int len1 = checkPalindrome(s, maxLen, i, i);
			
			//even
			int len2 = checkPalindrome(s, maxLen, i, i+1);
			
			int m= Math.max(len1, len2);
			
			if(maxLen<m) {
				maxLen=m;
				index= i-(m-1)/2;
			}
			
		}		
		
		return index!=-1?(s.substring(index,maxLen+index)) :"";       
    }

	private int checkPalindrome(String s, int maxLen, int l, int r) {
		while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
			if(r-l+1>maxLen) {
				maxLen=r-l+1;
			}
			l--;
			r++;
		}
		return maxLen;
	}
}
