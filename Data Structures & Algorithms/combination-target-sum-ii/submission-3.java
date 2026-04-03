class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		res.clear();
        Arrays.sort(candidates);
		dfs(0, candidates, new ArrayList<>(), target);
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
			dfs(i+1, nums, current, remaining - nums[i]);
			current.remove(current.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            dfs(i+1, nums, current, remaining);

	}
    
}