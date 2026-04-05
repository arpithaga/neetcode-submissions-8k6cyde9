class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }


        current.remove(current.size()-1);

        
        dfs(i+1,nums,current);

    }
}
