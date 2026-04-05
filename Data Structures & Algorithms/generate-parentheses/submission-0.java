class Solution {
    List<String> result = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		result.clear();
		dfs(n, new StringBuilder(), 0, 0);
		return result;
	}

	private void dfs(int n, StringBuilder current, int open, int close) {

		if (current.length() == 2 * n) {
			result.add(current.toString());
			return;
		}

		if (open < n) {
			current.append("(");
			dfs(n, current, open + 1, close);
			current.deleteCharAt(current.length() - 1);
		}

		if (close < open) {
			current.append(")");
			dfs(n, current, open, close + 1);
			current.deleteCharAt(current.length() - 1);
		}

	}
}
