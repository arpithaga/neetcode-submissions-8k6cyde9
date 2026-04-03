class Solution {
    public int longestConsecutive(int[] nums) {

       if (nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}

		// System.out.println(set);

		int max = 0;
		for (int p : set) {
			int length = 1;
			while (set.contains(p + length)) {
				length++;
			}

			max = Math.max(max, length);

		}

		return max;
    }
}
