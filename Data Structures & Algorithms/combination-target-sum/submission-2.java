class Solution {
    List<List<Integer>> res;
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		
		res=new ArrayList<>();
		backTrack(nums,0, 0, target,new ArrayList<>());
		return res;
    }

	private void backTrack(int[] nums, int sum, int index, int target, List<Integer> current) {
			
		if(sum>target) {
			return;
		}
		
		if(sum==target) {
			res.add(new ArrayList<>(current));
		}
		
		for(int i=index;i<nums.length;i++) {
			current.add(nums[i]);
			backTrack(nums,sum+nums[i],i,target,current);
			current.remove(current.size()-1);
		}
		
	}
}
