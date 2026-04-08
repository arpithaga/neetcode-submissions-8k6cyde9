class Solution {
    List<String> result2 = new ArrayList<>();

	public List<String> letterCombinations(String digits) {

		Map<Integer, String> map = new HashMap<>();

		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");

		backtracking(0, map, digits, new StringBuilder());

		return result2;
	}

	private void backtracking(int start, Map<Integer, String> map, String digits, StringBuilder s) {

		if (s.length() == digits.length()) {
            if(!s.isEmpty())
			result2.add(s.toString());
			return;
		}

		if (start >= digits.length()) {
			return;
		}

		String c = map.get(Character.getNumericValue(digits.charAt(start)));
		for (int k = 0; k < c.length(); k++) {
			s.append(c.charAt(k));
			backtracking(start + 1, map, digits, s);
			s.deleteCharAt(s.length() - 1);
		}

	}
}
