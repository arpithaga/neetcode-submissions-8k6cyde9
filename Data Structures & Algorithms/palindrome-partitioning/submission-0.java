class Solution {
    List<List<String>> reslt = new ArrayList<>();

	public List<List<String>> partition(String s) {
		reslt.clear();
		dfs(0, s, new ArrayList<>());
		return reslt;
	}

	private void dfs(int start, String s, List<String> current) {
		if (start >= s.length()) {
			reslt.add(new ArrayList<>(current));
			return;
		}
		
		for(int p=start;p<s.length();p++) {
		String p1=s.substring(start, p+1);
		if (checkPalindrome(p1)) {
			if(!p1.isEmpty()) {
			   current.add(p1);
			   dfs(p+1, s, current);
			   current.remove(current.size() - 1);
			}
		}
		
		}
		
		
	}

	private boolean checkPalindrome(String string) {
		
		if(string.length()==1) return true;
		
		for (int i = 0; i < string.length() / 2; i++) {
			if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}

}
