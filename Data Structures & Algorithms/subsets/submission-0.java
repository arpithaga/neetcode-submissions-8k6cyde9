class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.clear();
        dfs(0,nums,new ArrayList<>());
        return res;
    }

    private void dfs(int i,int[] nums,List<Integer> current){
        if(i>=nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        dfs(i+1,nums,current);

        current.remove(Integer.valueOf(nums[i]));
        dfs(i+1,nums,current);

    }
}
