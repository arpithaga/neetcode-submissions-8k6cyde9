class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
		res.clear();
		dfs(0, nums, new ArrayList<>(), target);
		return res;
	}

	private void dfs(int i, int[] nums, List<Integer> current, int remaining) {

		if (remaining == 0) {
			res.add(new ArrayList<>(current));
			return;
		}

		if (remaining < 0 || i >= nums.length) {
			return;
		}

			current.add(Integer.valueOf(nums[i]));
			dfs(i, nums, current, remaining - nums[i]);
			current.remove(current.size() - 1);
            dfs(i+1, nums, current, remaining);

	}
}
