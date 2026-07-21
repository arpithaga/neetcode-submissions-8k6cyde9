class Solution {
    public String longestPalindrome(String s) {
        int index=-1;
		int maxLen=0;
		
		for(int i=0;i<s.length();i++) {
			
			//odd
			int l=i,r=i;
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
				if(r-l+1>maxLen) {
					index=l;
					maxLen=r-l+1;
				}
				l--;
				r++;
			}
			
			//even
			l=i;
			r=i+1;
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
				if(r-l+1>maxLen) {
					index=l;
					maxLen=r-l+1;
				}
				l--;
				r++;
			}
			
		}		
		
		return index!=-1?(s.substring(index,index+maxLen)) :"";
    }
}
